package org.finos.waltz.jobs.tools.importers.licence.finos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.tools.importers.licence.finos.ImmutableComplianceTerm.Builder;
import org.finos.waltz.jobs.tools.importers.licence.finos.ImmutableComplianceTerm.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableComplianceTermDiffblueTest {
  /**
   * Test {@link ImmutableComplianceTerm#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableComplianceTerm#builder()}
   *   <li>{@link ImmutableComplianceTerm#complianceNotes(String)}
   *   <li>{@link ImmutableComplianceTerm#useCases(ComplianceUseCase[])}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableComplianceTerm Builder.build()", "Builder Builder.complianceNotes(String)",
      "Builder Builder.useCases(ComplianceUseCase[])"})
  void testBuilder() {
    // Arrange and Act
    Builder actualComplianceNotesResult = ImmutableComplianceTerm.builder().complianceNotes("Compliance Notes");

    // Assert
    assertSame(actualComplianceNotesResult, actualComplianceNotesResult.useCases(ComplianceUseCase.UB));
  }

  /**
   * Test Builder {@link Builder#description(String)}.
   * <p>
   * Method under test: {@link Builder#description(String)}
   */
  @Test
  @DisplayName("Test Builder description(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.description(String)"})
  void testBuilderDescription() {
    // Arrange
    Builder builderResult = ImmutableComplianceTerm.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.description("The characteristics of someone or something"));
  }

  /**
   * Test Builder {@link Builder#from(ComplianceTerm)}.
   * <p>
   * Method under test: {@link Builder#from(ComplianceTerm)}
   */
  @Test
  @DisplayName("Test Builder from(ComplianceTerm)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComplianceTerm)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableComplianceTerm.builder();
    ComplianceTerm instance = mock(ComplianceTerm.class);
    when(instance.complianceNotes()).thenReturn("Compliance Notes");
    when(instance.useCases()).thenReturn(null);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.type()).thenReturn(ComplianceType.CONDITION);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).complianceNotes();
    verify(instance).description();
    verify(instance).type();
    verify(instance).useCases();
    ImmutableComplianceTerm buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.useCases());
    assertEquals(ComplianceType.CONDITION, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ComplianceTerm)}.
   * <ul>
   *   <li>Then return build complianceNotes is {@code Compliance Notes}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComplianceTerm)}
   */
  @Test
  @DisplayName("Test Builder from(ComplianceTerm); then return build complianceNotes is 'Compliance Notes'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComplianceTerm)"})
  void testBuilderFrom_thenReturnBuildComplianceNotesIsComplianceNotes() {
    // Arrange
    Builder builderResult = ImmutableComplianceTerm.builder();
    ComplianceTerm instance = mock(ComplianceTerm.class);
    when(instance.complianceNotes()).thenReturn("Compliance Notes");
    when(instance.useCases()).thenReturn(new ComplianceUseCase[]{ComplianceUseCase.UB});
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.type()).thenReturn(ComplianceType.CONDITION);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).complianceNotes();
    verify(instance).description();
    verify(instance).type();
    verify(instance).useCases();
    ImmutableComplianceTerm buildResult = actualFromResult.build();
    assertEquals("Compliance Notes", buildResult.complianceNotes());
    assertEquals("Compliance Notes", builderResult.build().complianceNotes());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(ComplianceType.CONDITION, buildResult.type());
    assertArrayEquals(new ComplianceUseCase[]{ComplianceUseCase.UB}, buildResult.useCases());
  }

  /**
   * Test Builder {@link Builder#from(ComplianceTerm)}.
   * <ul>
   *   <li>Then return build complianceNotes is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComplianceTerm)}
   */
  @Test
  @DisplayName("Test Builder from(ComplianceTerm); then return build complianceNotes is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComplianceTerm)"})
  void testBuilderFrom_thenReturnBuildComplianceNotesIsNull() {
    // Arrange
    Builder builderResult = ImmutableComplianceTerm.builder();
    ComplianceTerm instance = mock(ComplianceTerm.class);
    when(instance.complianceNotes()).thenReturn(null);
    when(instance.useCases()).thenReturn(new ComplianceUseCase[]{ComplianceUseCase.UB});
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.type()).thenReturn(ComplianceType.CONDITION);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).complianceNotes();
    verify(instance).description();
    verify(instance).type();
    verify(instance).useCases();
    ImmutableComplianceTerm buildResult = actualFromResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.complianceNotes());
    assertNull(builderResult.build().complianceNotes());
    assertEquals(ComplianceType.CONDITION, buildResult.type());
    assertArrayEquals(new ComplianceUseCase[]{ComplianceUseCase.UB}, buildResult.useCases());
  }

  /**
   * Test Builder {@link Builder#from(ComplianceTerm)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComplianceTerm)}
   */
  @Test
  @DisplayName("Test Builder from(ComplianceTerm); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComplianceTerm)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableComplianceTerm.builder();
    ComplianceTerm instance = mock(ComplianceTerm.class);
    when(instance.useCases()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.type()).thenReturn(ComplianceType.CONDITION);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).type();
    verify(instance).useCases();
  }

  /**
   * Test Builder {@link Builder#type(ComplianceType)}.
   * <p>
   * Method under test: {@link Builder#type(ComplianceType)}
   */
  @Test
  @DisplayName("Test Builder type(ComplianceType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.type(ComplianceType)"})
  void testBuilderType() {
    // Arrange
    Builder builderResult = ImmutableComplianceTerm.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.type(ComplianceType.CONDITION));
  }

  /**
   * Test Json {@link Json#complianceNotes()}.
   * <p>
   * Method under test: {@link Json#complianceNotes()}
   */
  @Test
  @DisplayName("Test Json complianceNotes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.complianceNotes()"})
  void testJsonComplianceNotes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).complianceNotes());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setComplianceNotes(String)}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setType(ComplianceType)}
   *   <li>{@link Json#setUseCases(ComplianceUseCase[])}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setComplianceNotes(String)", "void Json.setDescription(String)",
      "void Json.setType(ComplianceType)", "void Json.setUseCases(ComplianceUseCase[])"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setComplianceNotes("Compliance Notes");
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setType(ComplianceType.CONDITION);
    actualJson.setUseCases(new ComplianceUseCase[]{ComplianceUseCase.UB});

    // Assert
    assertEquals("Compliance Notes", actualJson.complianceNotes);
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertEquals(ComplianceType.CONDITION, actualJson.type);
    assertArrayEquals(new ComplianceUseCase[]{ComplianceUseCase.UB}, actualJson.useCases);
  }

  /**
   * Test Json {@link Json#type()}.
   * <p>
   * Method under test: {@link Json#type()}
   */
  @Test
  @DisplayName("Test Json type()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ComplianceType Json.type()"})
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).type());
  }

  /**
   * Test Json {@link Json#useCases()}.
   * <p>
   * Method under test: {@link Json#useCases()}
   */
  @Test
  @DisplayName("Test Json useCases()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ComplianceUseCase[] Json.useCases()"})
  void testJsonUseCases() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).useCases());
  }
}
