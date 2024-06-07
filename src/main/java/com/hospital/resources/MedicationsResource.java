package com.hospital.resources;

import com.hospital.DTO.MultipartBody;
import com.hospital.entities.Medications;
import com.hospital.client.MedicationsService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Path("/medications")
public class MedicationsResource {

    @Inject
    MedicationsService medicationsService;

    @POST
    @Path("/upload/{id}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@PathParam("id") int id, MultipartBody multipartBody) {
        try {
            Files.createDirectories(Paths.get("uploads"));

            java.nio.file.Path path = Paths.get("uploads/" + multipartBody.fileName);
            Files.deleteIfExists(path);

            try (InputStream fileStream = multipartBody.file) {
                Files.copy(fileStream, path, StandardCopyOption.REPLACE_EXISTING);
            }

            Medications medication = medicationsService.findById(id);
            if (medication == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Medication with ID " + id + " not found")
                        .build();
            }

            medication.setInstructionFilePath(path.toString());
            medicationsService.update(medication);

            return Response.ok("File uploaded successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error uploading file: " + e.getMessage())
                    .build();
        }
    }
}