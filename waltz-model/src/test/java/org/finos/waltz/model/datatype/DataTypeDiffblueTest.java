package org.finos.waltz.model.datatype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataTypeDiffblueTest {
  /**
   * Test {@link DataType#concrete()}.
   *
   * <p>Method under test: {@link DataType#concrete()}
   */
  @Test
  @DisplayName("Test concrete()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataType.concrete()"})
  void testConcrete() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .concrete());
  }

  /**
   * Test {@link DataType#deprecated()}.
   *
   * <p>Method under test: {@link DataType#deprecated()}
   */
  @Test
  @DisplayName("Test deprecated()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataType.deprecated()"})
  void testDeprecated() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .deprecated());
  }

  /**
   * Test {@link DataType#kind()}.
   *
   * <p>Method under test: {@link DataType#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind DataType.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .kind());
  }

  /**
   * Test {@link DataType#unknown()}.
   *
   * <p>Method under test: {@link DataType#unknown()}
   */
  @Test
  @DisplayName("Test unknown()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataType.unknown()"})
  void testUnknown() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .unknown());
  }

  /**
   * Test {@link DataType#entityReference()}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link DataType#entityReference()}
   */
  @Test
  @DisplayName("Test entityReference(); then return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference DataType.entityReference()"})
  void testEntityReference_thenReturnImmutableEntityReference() {
    // Arrange and Act
    EntityReference actualEntityReferenceResult =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .entityReference();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", actualEntityReferenceResult.description());
    assertEquals(1L, actualEntityReferenceResult.id());
    assertEquals(EntityKind.DATA_TYPE, actualEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualEntityReferenceResult.entityLifecycleStatus());
  }
}
