package org.finos.waltz.jobs.tools.importers.licence.finos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableComplianceTermDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableComplianceTerm#builder()}
   *   <li>{@link ImmutableComplianceTerm#complianceNotes(String)}
   *   <li>{@link ImmutableComplianceTerm#useCases(ComplianceUseCase[])}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableComplianceTerm.Builder actualComplianceNotesResult = ImmutableComplianceTerm.builder()
        .complianceNotes("Compliance Notes");

    // Assert
    assertSame(actualComplianceNotesResult, actualComplianceNotesResult.useCases(ComplianceUseCase.UB));
  }

  /**
   * Method under test:
   * {@link ImmutableComplianceTerm.Builder#description(String)}
   */
  @Test
  void testBuilderDescription() {
    // Arrange
    ImmutableComplianceTerm.Builder builderResult = ImmutableComplianceTerm.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutableComplianceTerm.Builder#from(ComplianceTerm)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableComplianceTerm.Builder builderResult = ImmutableComplianceTerm.builder();
    ComplianceTerm instance = mock(ComplianceTerm.class);
    when(instance.complianceNotes()).thenReturn("Compliance Notes");
    when(instance.useCases()).thenReturn(new ComplianceUseCase[]{ComplianceUseCase.UB});
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.type()).thenReturn(ComplianceType.CONDITION);

    // Act
    ImmutableComplianceTerm.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).complianceNotes();
    verify(instance).description();
    verify(instance).type();
    verify(instance).useCases();
    ImmutableComplianceTerm buildResult = builderResult.build();
    assertEquals("Compliance Notes", buildResult.complianceNotes());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(ComplianceType.CONDITION, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplianceTerm.Builder#from(ComplianceTerm)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableComplianceTerm.Builder builderResult = ImmutableComplianceTerm.builder();
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
   * Method under test:
   * {@link ImmutableComplianceTerm.Builder#from(ComplianceTerm)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableComplianceTerm.Builder builderResult = ImmutableComplianceTerm.builder();
    ComplianceTerm instance = mock(ComplianceTerm.class);
    when(instance.complianceNotes()).thenReturn(null);
    when(instance.useCases()).thenReturn(new ComplianceUseCase[]{ComplianceUseCase.UB});
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.type()).thenReturn(ComplianceType.CONDITION);

    // Act
    ImmutableComplianceTerm.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).complianceNotes();
    verify(instance).description();
    verify(instance).type();
    verify(instance).useCases();
    ImmutableComplianceTerm buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.complianceNotes());
    assertEquals(ComplianceType.CONDITION, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplianceTerm.Builder#from(ComplianceTerm)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableComplianceTerm.Builder builderResult = ImmutableComplianceTerm.builder();
    ComplianceTerm instance = mock(ComplianceTerm.class);
    when(instance.complianceNotes()).thenReturn("Compliance Notes");
    when(instance.useCases()).thenReturn(null);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.type()).thenReturn(ComplianceType.CONDITION);

    // Act
    ImmutableComplianceTerm.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).complianceNotes();
    verify(instance).description();
    verify(instance).type();
    verify(instance).useCases();
    ImmutableComplianceTerm buildResult = builderResult.build();
    assertEquals("Compliance Notes", buildResult.complianceNotes());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.useCases());
    assertEquals(ComplianceType.CONDITION, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplianceTerm.Builder#type(ComplianceType)}
   */
  @Test
  void testBuilderType() {
    // Arrange
    ImmutableComplianceTerm.Builder builderResult = ImmutableComplianceTerm.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.type(ComplianceType.CONDITION));
  }

  /**
   * Method under test: {@link ImmutableComplianceTerm#copyOf(ComplianceTerm)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ComplianceTerm instance = mock(ComplianceTerm.class);
    when(instance.complianceNotes()).thenReturn("Compliance Notes");
    when(instance.useCases()).thenReturn(new ComplianceUseCase[]{ComplianceUseCase.UB});
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.type()).thenReturn(ComplianceType.CONDITION);

    // Act
    ImmutableComplianceTerm actualCopyOfResult = ImmutableComplianceTerm.copyOf(instance);

    // Assert
    verify(instance).complianceNotes();
    verify(instance).description();
    verify(instance).type();
    verify(instance).useCases();
    assertEquals("Compliance Notes", actualCopyOfResult.complianceNotes());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(ComplianceType.CONDITION, actualCopyOfResult.type());
    assertArrayEquals(new ComplianceUseCase[]{ComplianceUseCase.UB}, actualCopyOfResult.useCases());
  }

  /**
   * Method under test:
   * {@link ImmutableComplianceTerm#fromJson(ImmutableComplianceTerm.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableComplianceTerm.Json json = new ImmutableComplianceTerm.Json();
    json.setType(ComplianceType.CONDITION);
    json.setDescription("Json");
    json.setUseCases(null);
    json.setComplianceNotes(null);

    // Act
    ImmutableComplianceTerm actualFromJsonResult = ImmutableComplianceTerm.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertNull(actualFromJsonResult.useCases());
    assertNull(actualFromJsonResult.complianceNotes());
    assertEquals(ComplianceType.CONDITION, actualFromJsonResult.type());
  }

  /**
   * Method under test: {@link ImmutableComplianceTerm.Json#complianceNotes()}
   */
  @Test
  void testJsonComplianceNotes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplianceTerm.Json()).complianceNotes());
  }

  /**
   * Method under test: {@link ImmutableComplianceTerm.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplianceTerm.Json()).description());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableComplianceTerm.Json}
   *   <li>{@link ImmutableComplianceTerm.Json#setComplianceNotes(String)}
   *   <li>{@link ImmutableComplianceTerm.Json#setDescription(String)}
   *   <li>{@link ImmutableComplianceTerm.Json#setType(ComplianceType)}
   *   <li>{@link ImmutableComplianceTerm.Json#setUseCases(ComplianceUseCase[])}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableComplianceTerm.Json actualJson = new ImmutableComplianceTerm.Json();
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
   * Method under test: {@link ImmutableComplianceTerm.Json#type()}
   */
  @Test
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplianceTerm.Json()).type());
  }

  /**
   * Method under test: {@link ImmutableComplianceTerm.Json#useCases()}
   */
  @Test
  void testJsonUseCases() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplianceTerm.Json()).useCases());
  }
}
