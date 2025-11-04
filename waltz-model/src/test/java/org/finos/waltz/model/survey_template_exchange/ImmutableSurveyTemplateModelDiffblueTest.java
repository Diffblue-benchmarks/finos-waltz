package org.finos.waltz.model.survey_template_exchange;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableSurveyTemplateModelDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyTemplateModel#builder()}
   *   <li>{@link ImmutableSurveyTemplateModel#description(String)}
   *   <li>{@link ImmutableSurveyTemplateModel#externalId(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableSurveyTemplateModel.Builder actualExternalIdResult = ImmutableSurveyTemplateModel.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");

    // Assert
    assertSame(actualExternalIdResult, actualExternalIdResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableSurveyTemplateModel.Builder builderResult = ImmutableSurveyTemplateModel.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyTemplateModel.Builder builderResult = ImmutableSurveyTemplateModel.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableSurveyTemplateModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyTemplateModel.Builder builderResult = ImmutableSurveyTemplateModel.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableSurveyTemplateModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyTemplateModel.Builder builderResult = ImmutableSurveyTemplateModel.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyTemplateModel.Builder builderResult = ImmutableSurveyTemplateModel.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSurveyTemplateModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSurveyTemplateModel.Builder builderResult = ImmutableSurveyTemplateModel.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableSurveyTemplateModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSurveyTemplateModel.Builder builderResult = ImmutableSurveyTemplateModel.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableSurveyTemplateModel.Builder builderResult = ImmutableSurveyTemplateModel.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplateModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel.Builder#from(SurveyTemplateModel)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableSurveyTemplateModel.Builder builderResult = ImmutableSurveyTemplateModel.builder();
    SurveyTemplateModel instance = mock(SurveyTemplateModel.class);
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.ownerEmployeeId()).thenReturn("42");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplateModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).issuanceRole();
    verify(instance).ownerEmployeeId();
    verify(instance).targetEntityKind();
    ImmutableSurveyTemplateModel buildResult = builderResult.build();
    assertEquals("42", buildResult.ownerEmployeeId());
    assertEquals("Issuance Role", buildResult.issuanceRole());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.targetEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel.Builder#from(SurveyTemplateModel)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableSurveyTemplateModel.Builder builderResult = ImmutableSurveyTemplateModel.builder();
    SurveyTemplateModel instance = mock(SurveyTemplateModel.class);
    when(instance.issuanceRole()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.ownerEmployeeId()).thenReturn("42");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).issuanceRole();
    verify(instance).ownerEmployeeId();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel.Builder#from(SurveyTemplateModel)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableSurveyTemplateModel.Builder builderResult = ImmutableSurveyTemplateModel.builder();
    SurveyTemplateModel instance = mock(SurveyTemplateModel.class);
    when(instance.issuanceRole()).thenReturn(null);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.ownerEmployeeId()).thenReturn("42");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplateModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).issuanceRole();
    verify(instance).ownerEmployeeId();
    verify(instance).targetEntityKind();
    ImmutableSurveyTemplateModel buildResult = builderResult.build();
    assertEquals("42", buildResult.ownerEmployeeId());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.issuanceRole());
    assertEquals(EntityKind.ALL, buildResult.targetEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel.Builder#from(SurveyTemplateModel)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableSurveyTemplateModel.Builder builderResult = ImmutableSurveyTemplateModel.builder();
    SurveyTemplateModel instance = mock(SurveyTemplateModel.class);
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn(null);
    when(instance.ownerEmployeeId()).thenReturn("42");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplateModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).issuanceRole();
    verify(instance).ownerEmployeeId();
    verify(instance).targetEntityKind();
    ImmutableSurveyTemplateModel buildResult = builderResult.build();
    assertEquals("42", buildResult.ownerEmployeeId());
    assertEquals("Issuance Role", buildResult.issuanceRole());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.targetEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel.Builder#from(SurveyTemplateModel)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableSurveyTemplateModel.Builder builderResult = ImmutableSurveyTemplateModel.builder();
    SurveyTemplateModel instance = mock(SurveyTemplateModel.class);
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.ownerEmployeeId()).thenReturn("42");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplateModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).issuanceRole();
    verify(instance).ownerEmployeeId();
    verify(instance).targetEntityKind();
    ImmutableSurveyTemplateModel buildResult = builderResult.build();
    assertEquals("42", buildResult.ownerEmployeeId());
    assertEquals("Issuance Role", buildResult.issuanceRole());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.targetEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplateModel.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableSurveyTemplateModel.Builder builderResult = ImmutableSurveyTemplateModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel.Builder#ownerEmployeeId(String)}
   */
  @Test
  void testBuilderOwnerEmployeeId() {
    // Arrange
    ImmutableSurveyTemplateModel.Builder builderResult = ImmutableSurveyTemplateModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ownerEmployeeId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel.Builder#targetEntityKind(EntityKind)}
   */
  @Test
  void testBuilderTargetEntityKind() {
    // Arrange
    ImmutableSurveyTemplateModel.Builder builderResult = ImmutableSurveyTemplateModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetEntityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel#copyOf(SurveyTemplateModel)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyTemplateModel instance = mock(SurveyTemplateModel.class);
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.ownerEmployeeId()).thenReturn("42");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplateModel actualCopyOfResult = ImmutableSurveyTemplateModel.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).issuanceRole();
    verify(instance).ownerEmployeeId();
    verify(instance).targetEntityKind();
    assertEquals("42", actualCopyOfResult.ownerEmployeeId());
    assertEquals("Issuance Role", actualCopyOfResult.issuanceRole());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel#copyOf(SurveyTemplateModel)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SurveyTemplateModel instance = mock(SurveyTemplateModel.class);
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.ownerEmployeeId()).thenReturn("42");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplateModel actualCopyOfResult = ImmutableSurveyTemplateModel.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).issuanceRole();
    verify(instance).ownerEmployeeId();
    verify(instance).targetEntityKind();
    assertEquals("42", actualCopyOfResult.ownerEmployeeId());
    assertEquals("Issuance Role", actualCopyOfResult.issuanceRole());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel#fromJson(ImmutableSurveyTemplateModel.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyTemplateModel.Json json = new ImmutableSurveyTemplateModel.Json();
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setTargetEntityKind(EntityKind.ALL);
    json.setIssuanceRole(null);
    json.setOwnerEmployeeId("Json");

    // Act
    ImmutableSurveyTemplateModel actualFromJsonResult = ImmutableSurveyTemplateModel.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.ownerEmployeeId());
    assertNull(actualFromJsonResult.description());
    assertNull(actualFromJsonResult.issuanceRole());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetEntityKind());
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplateModel.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyTemplateModel.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplateModel.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyTemplateModel.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplateModel.Json#issuanceRole()}
   */
  @Test
  void testJsonIssuanceRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyTemplateModel.Json()).issuanceRole());
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplateModel.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyTemplateModel.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyTemplateModel.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyTemplateModel.Json actualJson = new ImmutableSurveyTemplateModel.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.issuanceRole);
    assertNull(actualJson.name);
    assertNull(actualJson.ownerEmployeeId);
    assertNull(actualJson.targetEntityKind);
    assertFalse(actualJson.externalId.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel.Json#ownerEmployeeId()}
   */
  @Test
  void testJsonOwnerEmployeeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyTemplateModel.Json()).ownerEmployeeId());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateModel.Json#targetEntityKind()}
   */
  @Test
  void testJsonTargetEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyTemplateModel.Json()).targetEntityKind());
  }
}
