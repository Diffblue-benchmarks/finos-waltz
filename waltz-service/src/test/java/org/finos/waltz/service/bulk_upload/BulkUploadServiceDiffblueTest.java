package org.finos.waltz.service.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.bulk_upload.BulkUploadCommand;
import org.finos.waltz.model.bulk_upload.BulkUploadMode;
import org.finos.waltz.model.bulk_upload.ImmutableBulkUploadCommand;
import org.finos.waltz.model.bulk_upload.ImmutableResolveBulkUploadRequestParameters;
import org.finos.waltz.model.bulk_upload.ImmutableResolveBulkUploadRequestParameters.Builder;
import org.finos.waltz.model.bulk_upload.ResolveBulkUploadRequestParameters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BulkUploadServiceDiffblueTest {
  @InjectMocks private BulkUploadService bulkUploadService;

  /**
   * Test {@link BulkUploadService#resolve(ResolveBulkUploadRequestParameters)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadService#resolve(ResolveBulkUploadRequestParameters)}
   */
  @Test
  @DisplayName(
      "Test resolve(ResolveBulkUploadRequestParameters); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List BulkUploadService.resolve(ResolveBulkUploadRequestParameters)"
  })
  void testResolve_thenThrowIllegalArgumentException() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            bulkUploadService.resolve(
                rowSubjectQualifierResult
                    .targetDomain(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build()));
  }

  /**
   * Test {@link BulkUploadService#upload(BulkUploadCommand, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadService#upload(BulkUploadCommand, String)}
   */
  @Test
  @DisplayName("Test upload(BulkUploadCommand, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer BulkUploadService.upload(BulkUploadCommand, String)"})
  void testUpload_thenThrowIllegalArgumentException() {
    // Arrange
    ImmutableBulkUploadCommand.Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    ImmutableBulkUploadCommand.Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            bulkUploadService.upload(
                rowSubjectQualifierResult
                    .targetDomain(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .uploadMode(BulkUploadMode.ADD_ONLY)
                    .build(),
                "janedoe"));
  }
}
