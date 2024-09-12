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
@Table(name = "user_image_table")
public class UserImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "사용자 이미지 고유 ID", example = "1")
    private Long userImageCid;

    @ManyToOne
    @JoinColumn(name = "face_photo_1")
    @Schema(description = "얼굴 사진 1 참조 ID")
    private ImageEntity facePhoto1;

    @ManyToOne
    @JoinColumn(name = "face_photo_2")
    @Schema(description = "얼굴 사진 2 참조 ID")
    private ImageEntity facePhoto2;

    @ManyToOne
    @JoinColumn(name = "body_photo")
    @Schema(description = "전신 사진 참조 ID")
    private ImageEntity bodyPhoto;
}
