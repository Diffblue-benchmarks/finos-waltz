package org.finos.waltz.service.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.bulk_upload.BulkUpdateMode;
import org.finos.waltz.model.bulk_upload.ChangeOperation;
import org.finos.waltz.model.bulk_upload.taxonomy.BulkTaxonomyValidatedItem;
import org.finos.waltz.model.bulk_upload.taxonomy.BulkTaxonomyValidationResult;
import org.finos.waltz.model.bulk_upload.taxonomy.ChangedFieldType;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyItem;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyParseError;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyValidatedItem;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyValidatedItem.Builder;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyValidationResult;
import org.finos.waltz.service.taxonomy_management.BulkTaxonomyItemParser.InputFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BulkTaxonomyChangeServiceDiffblueTest {
  @InjectMocks private BulkTaxonomyChangeService bulkTaxonomyChangeService;

  /**
   * Test {@link BulkTaxonomyChangeService#previewBulk(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#previewBulk(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName("Test previewBulk(EntityReference, String, InputFormat, BulkUpdateMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkTaxonomyValidationResult BulkTaxonomyChangeService.previewBulk(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testPreviewBulk() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            bulkTaxonomyChangeService.previewBulk(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "Input Str",
                InputFormat.CSV,
                BulkUpdateMode.ADD_ONLY));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#previewBulk(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#previewBulk(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName("Test previewBulk(EntityReference, String, InputFormat, BulkUpdateMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkTaxonomyValidationResult BulkTaxonomyChangeService.previewBulk(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testPreviewBulk2() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            bulkTaxonomyChangeService.previewBulk(
                ImmutableAppGroupEntry.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .build(),
                "Input Str",
                InputFormat.CSV,
                BulkUpdateMode.ADD_ONLY));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#applyBulk(EntityReference, BulkTaxonomyValidationResult,
   * String)}.
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#applyBulk(EntityReference,
   * BulkTaxonomyValidationResult, String)}
   */
  @Test
  @DisplayName("Test applyBulk(EntityReference, BulkTaxonomyValidationResult, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.taxonomy.BulkTaxonomyApplyResult BulkTaxonomyChangeService.applyBulk(EntityReference, BulkTaxonomyValidationResult, String)"
  })
  void testApplyBulk() {
    // Arrange
    ImmutableEntityReference taxonomyRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ImmutableBulkTaxonomyValidationResult.Builder builderResult =
        ImmutableBulkTaxonomyValidationResult.builder();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            bulkTaxonomyChangeService.applyBulk(
                taxonomyRef,
                builderResult
                    .error(
                        ImmutableBulkTaxonomyParseError.builder()
                            .column(1)
                            .line(2)
                            .message("Not all who wander are lost")
                            .build())
                    .build(),
                "42"));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#applyBulk(EntityReference, BulkTaxonomyValidationResult,
   * String)}.
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#applyBulk(EntityReference,
   * BulkTaxonomyValidationResult, String)}
   */
  @Test
  @DisplayName("Test applyBulk(EntityReference, BulkTaxonomyValidationResult, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.taxonomy.BulkTaxonomyApplyResult BulkTaxonomyChangeService.applyBulk(EntityReference, BulkTaxonomyValidationResult, String)"
  })
  void testApplyBulk2() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            bulkTaxonomyChangeService.applyBulk(
                ImmutableAppGroupEntry.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .build(),
                mock(BulkTaxonomyValidationResult.class),
                "42"));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}.
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}
   */
  @Test
  @DisplayName("Test requiresHierarchyRebuild(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkTaxonomyChangeService.requiresHierarchyRebuild(Collection)"})
  void testRequiresHierarchyRebuild() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> items = new ArrayList<>();

    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    items.add(
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());

    // Act and Assert
    assertTrue(BulkTaxonomyChangeService.requiresHierarchyRebuild(items));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}.
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}
   */
  @Test
  @DisplayName("Test requiresHierarchyRebuild(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkTaxonomyChangeService.requiresHierarchyRebuild(Collection)"})
  void testRequiresHierarchyRebuild2() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> items = new ArrayList<>();

    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    items.add(
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());

    Builder changeOperationResult2 =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult2 =
        changeOperationResult2.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    items.add(
        existingItemReferenceResult2
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());

    // Act and Assert
    assertTrue(BulkTaxonomyChangeService.requiresHierarchyRebuild(items));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}.
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}
   */
  @Test
  @DisplayName("Test requiresHierarchyRebuild(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkTaxonomyChangeService.requiresHierarchyRebuild(Collection)"})
  void testRequiresHierarchyRebuild3() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> items = new ArrayList<>();

    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.UPDATE);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    items.add(
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());

    Builder changeOperationResult2 =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult2 =
        changeOperationResult2.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    items.add(
        existingItemReferenceResult2
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());

    // Act and Assert
    assertTrue(BulkTaxonomyChangeService.requiresHierarchyRebuild(items));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}.
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}
   */
  @Test
  @DisplayName("Test requiresHierarchyRebuild(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkTaxonomyChangeService.requiresHierarchyRebuild(Collection)"})
  void testRequiresHierarchyRebuild4() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> items = new ArrayList<>();

    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.NONE);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    items.add(
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());

    // Act and Assert
    assertFalse(BulkTaxonomyChangeService.requiresHierarchyRebuild(items));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}.
   *
   * <ul>
   *   <li>Given builder addChangedFields {@code PARENT_EXTERNAL_ID}.
   * </ul>
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}
   */
  @Test
  @DisplayName(
      "Test requiresHierarchyRebuild(Collection); given builder addChangedFields 'PARENT_EXTERNAL_ID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkTaxonomyChangeService.requiresHierarchyRebuild(Collection)"})
  void testRequiresHierarchyRebuild_givenBuilderAddChangedFieldsParentExternalId() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    builderResult.addChangedFields(ChangedFieldType.PARENT_EXTERNAL_ID);

    Builder changeOperationResult = builderResult.changeOperation(ChangeOperation.UPDATE);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem immutableBulkTaxonomyValidatedItem =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    ArrayList<BulkTaxonomyValidatedItem> items = new ArrayList<>();
    items.add(immutableBulkTaxonomyValidatedItem);

    // Act and Assert
    assertTrue(BulkTaxonomyChangeService.requiresHierarchyRebuild(items));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}
   */
  @Test
  @DisplayName("Test requiresHierarchyRebuild(Collection); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkTaxonomyChangeService.requiresHierarchyRebuild(Collection)"})
  void testRequiresHierarchyRebuild_thenReturnFalse() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> items = new ArrayList<>();

    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.UPDATE);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    items.add(
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());

    // Act and Assert
    assertFalse(BulkTaxonomyChangeService.requiresHierarchyRebuild(items));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}
   */
  @Test
  @DisplayName("Test requiresHierarchyRebuild(Collection); when ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkTaxonomyChangeService.requiresHierarchyRebuild(Collection)"})
  void testRequiresHierarchyRebuild_whenArrayList_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BulkTaxonomyChangeService.requiresHierarchyRebuild(new ArrayList<>()));
  }
}
