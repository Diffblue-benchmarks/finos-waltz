package org.finos.waltz.model.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.involvement.ImmutableInvolvement.Builder;
import org.finos.waltz.model.involvement.ImmutableInvolvement.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementDiffblueTest {
  /**
   * Test {@link ImmutableInvolvement#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableInvolvement#builder()}
   *   <li>{@link ImmutableInvolvement#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableInvolvement Builder.build()", "Builder Builder.provenance(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableInvolvement.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.provenance("Provenance"));
  }

  /**
   * Test Builder {@link Builder#employeeId(String)}.
   * <p>
   * Method under test: {@link Builder#employeeId(String)}
   */
  @Test
  @DisplayName("Test Builder employeeId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.employeeId(String)"})
  void testBuilderEmployeeId() {
    // Arrange
    Builder builderResult = ImmutableInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.employeeId("42"));
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(Involvement)} with {@code Involvement}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build employeeId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Involvement)}
   */
  @Test
  @DisplayName("Test Builder from(Involvement) with 'Involvement'; given one; then builder build employeeId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Involvement)"})
  void testBuilderFromWithInvolvement_givenOne_thenBuilderBuildEmployeeIdIs42() {
    // Arrange
    Builder builderResult = ImmutableInvolvement.builder();
    Involvement instance = mock(Involvement.class);
    when(instance.kindId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.employeeId()).thenReturn("42");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).employeeId();
    verify(instance).entityReference();
    verify(instance).isReadOnly();
    verify(instance).kindId();
    verify(instance).provenance();
    ImmutableInvolvement buildResult = builderResult.build();
    assertEquals("42", buildResult.employeeId());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.kindId());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Involvement)} with {@code Involvement}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Involvement)}
   */
  @Test
  @DisplayName("Test Builder from(Involvement) with 'Involvement'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Involvement)"})
  void testBuilderFromWithInvolvement_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableInvolvement.builder();
    Involvement instance = mock(Involvement.class);
    when(instance.kindId()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.employeeId()).thenReturn("42");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).employeeId();
    verify(instance).entityReference();
    verify(instance).isReadOnly();
    verify(instance).kindId();
    verify(instance).provenance();
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   * <ul>
   *   <li>Given {@code Provenance}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; given 'Provenance'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_givenProvenance_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvement.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#isReadOnly(boolean)}.
   * <p>
   * Method under test: {@link Builder#isReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Builder isReadOnly(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isReadOnly(boolean)"})
  void testBuilderIsReadOnly() {
    // Arrange
    Builder builderResult = ImmutableInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Test Builder {@link Builder#kindId(long)}.
   * <p>
   * Method under test: {@link Builder#kindId(long)}
   */
  @Test
  @DisplayName("Test Builder kindId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.kindId(long)"})
  void testBuilderKindId() {
    // Arrange
    Builder builderResult = ImmutableInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kindId(1L));
  }

  /**
   * Test Json {@link Json#employeeId()}.
   * <p>
   * Method under test: {@link Json#employeeId()}
   */
  @Test
  @DisplayName("Test Json employeeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.employeeId()"})
  void testJsonEmployeeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).employeeId());
  }

  /**
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReference());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setEmployeeId(String)}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setProvenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setEmployeeId(String)",
      "void Json.setEntityReference(EntityReference)", "void Json.setProvenance(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setEmployeeId("42");
    actualJson.setEntityReference(null);
    actualJson.setProvenance("Provenance");

    // Assert
    assertEquals("42", actualJson.employeeId);
    assertEquals("Provenance", actualJson.provenance);
    assertNull(actualJson.entityReference);
    assertEquals(0L, actualJson.kindId);
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
    assertFalse(actualJson.kindIdIsSet);
  }

  /**
   * Test Json {@link Json#isReadOnly()}.
   * <p>
   * Method under test: {@link Json#isReadOnly()}
   */
  @Test
  @DisplayName("Test Json isReadOnly()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isReadOnly()"})
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isReadOnly());
  }

  /**
   * Test Json {@link Json#kindId()}.
   * <p>
   * Method under test: {@link Json#kindId()}
   */
  @Test
  @DisplayName("Test Json kindId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.kindId()"})
  void testJsonKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kindId());
  }

  /**
   * Test Json {@link Json#provenance()}.
   * <p>
   * Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).provenance());
  }

  /**
   * Test Json {@link Json#setIsReadOnly(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsReadOnly(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsReadOnly(boolean)"})
  void testJsonSetIsReadOnly() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Test Json {@link Json#setKindId(long)}.
   * <p>
   * Method under test: {@link Json#setKindId(long)}
   */
  @Test
  @DisplayName("Test Json setKindId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setKindId(long)"})
  void testJsonSetKindId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setKindId(1L);

    // Assert
    assertEquals(1L, json.kindId);
    assertTrue(json.kindIdIsSet);
  }
}
