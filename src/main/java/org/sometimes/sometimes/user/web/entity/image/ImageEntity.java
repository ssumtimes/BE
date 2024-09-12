package org.sometimes.sometimes.user.web.entity.image;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "image_table")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "이미지 고유 ID", example = "1")
    private Long imageCid;

    @Schema(description = "이미지 경로 (URL)", example = "https://aws.s3.com/yourimage.jpg")
    private String path;

    @Schema(description = "이미지 UUID", example = "abcd-efgh-1234")
    private String name;
}