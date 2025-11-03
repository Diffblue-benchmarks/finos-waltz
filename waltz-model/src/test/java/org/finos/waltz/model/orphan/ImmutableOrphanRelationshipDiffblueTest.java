package org.finos.waltz.model.orphan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.orphan.ImmutableOrphanRelationship.Builder;
import org.finos.waltz.model.orphan.ImmutableOrphanRelationship.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOrphanRelationshipDiffblueTest {
  /**
   * Test Builder {@link Builder#entityA(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityA(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityA(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityA(EntityReference)"})
  void testBuilderEntityA_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityA(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#entityB(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityB(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityB(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityB(EntityReference)"})
  void testBuilderEntityB_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityB(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(OrphanRelationship)}.
   * <p>
   * Method under test: {@link Builder#from(OrphanRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(OrphanRelationship)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OrphanRelationship)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();
    OrphanRelationship instance = mock(OrphanRelationship.class);
    when(instance.entityB()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityA()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityA();
    verify(instance).entityB();
  }

  /**
   * Test Builder {@link Builder#from(OrphanRelationship)}.
   * <p>
   * Method under test: {@link Builder#from(OrphanRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(OrphanRelationship)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OrphanRelationship)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();
    OrphanRelationship instance = mock(OrphanRelationship.class);
    when(instance.orphanSide()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityB()).thenReturn(mock(EntityReference.class));
    when(instance.entityA()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityA();
    verify(instance).entityB();
    verify(instance).orphanSide();
  }

  /**
   * Test Builder {@link Builder#from(OrphanRelationship)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then builder build orphanSide is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(OrphanRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(OrphanRelationship); given 'A'; then builder build orphanSide is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OrphanRelationship)"})
  void testBuilderFrom_givenA_thenBuilderBuildOrphanSideIsA() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();
    OrphanRelationship instance = mock(OrphanRelationship.class);
    when(instance.orphanSide()).thenReturn(OrphanSide.A);
    when(instance.entityB()).thenReturn(mock(EntityReference.class));
    when(instance.entityA()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityA();
    verify(instance).entityB();
    verify(instance).orphanSide();
    assertEquals(OrphanSide.A, builderResult.build().orphanSide());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#orphanSide(OrphanSide)}.
   * <p>
   * Method under test: {@link Builder#orphanSide(OrphanSide)}
   */
  @Test
  @DisplayName("Test Builder orphanSide(OrphanSide)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.orphanSide(OrphanSide)"})
  void testBuilderOrphanSide() {
    // Arrange
    Builder builderResult = ImmutableOrphanRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.orphanSide(OrphanSide.A));
  }

  /**
   * Test Json {@link Json#entityA()}.
   * <p>
   * Method under test: {@link Json#entityA()}
   */
  @Test
  @DisplayName("Test Json entityA()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityA()"})
  void testJsonEntityA() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityA());
  }

  /**
   * Test Json {@link Json#entityB()}.
   * <p>
   * Method under test: {@link Json#entityB()}
   */
  @Test
  @DisplayName("Test Json entityB()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityB()"})
  void testJsonEntityB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityB());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setEntityA(EntityReference)}
   *   <li>{@link Json#setEntityB(EntityReference)}
   *   <li>{@link Json#setOrphanSide(OrphanSide)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setEntityA(EntityReference)",
      "void Json.setEntityB(EntityReference)", "void Json.setOrphanSide(OrphanSide)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setEntityA(null);
    actualJson.setEntityB(null);
    actualJson.setOrphanSide(OrphanSide.A);

    // Assert
    assertNull(actualJson.entityA);
    assertNull(actualJson.entityB);
    assertEquals(OrphanSide.A, actualJson.orphanSide);
  }

  /**
   * Test Json {@link Json#orphanSide()}.
   * <p>
   * Method under test: {@link Json#orphanSide()}
   */
  @Test
  @DisplayName("Test Json orphanSide()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OrphanSide Json.orphanSide()"})
  void testJsonOrphanSide() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).orphanSide());
  }
}
