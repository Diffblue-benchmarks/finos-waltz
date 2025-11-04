package org.finos.waltz.model.survey;

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
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableSurveyTemplateChangeCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyTemplateChangeCommand#builder()}
   *   <li>{@link ImmutableSurveyTemplateChangeCommand#description(String)}
   *   <li>{@link ImmutableSurveyTemplateChangeCommand#externalId(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableSurveyTemplateChangeCommand.Builder actualExternalIdResult = ImmutableSurveyTemplateChangeCommand.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableSurveyTemplateChangeCommand.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableSurveyTemplateChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableSurveyTemplateChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSurveyTemplateChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableSurveyTemplateChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableSurveyTemplateChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableSurveyTemplateChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplateChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#from(SurveyTemplateChangeCommand)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    SurveyTemplateChangeCommand instance = mock(SurveyTemplateChangeCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplateChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).issuanceRole();
    verify(instance).targetEntityKind();
    ImmutableSurveyTemplateChangeCommand buildResult = builderResult.build();
    assertEquals("Issuance Role", buildResult.issuanceRole());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.targetEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#from(SurveyTemplateChangeCommand)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    SurveyTemplateChangeCommand instance = mock(SurveyTemplateChangeCommand.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#from(SurveyTemplateChangeCommand)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    SurveyTemplateChangeCommand instance = mock(SurveyTemplateChangeCommand.class);
    when(instance.description()).thenReturn(null);
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplateChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).issuanceRole();
    verify(instance).targetEntityKind();
    ImmutableSurveyTemplateChangeCommand buildResult = builderResult.build();
    assertEquals("Issuance Role", buildResult.issuanceRole());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.targetEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#from(SurveyTemplateChangeCommand)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    SurveyTemplateChangeCommand instance = mock(SurveyTemplateChangeCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.issuanceRole()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplateChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).issuanceRole();
    verify(instance).targetEntityKind();
    ImmutableSurveyTemplateChangeCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.issuanceRole());
    assertEquals(EntityKind.ALL, buildResult.targetEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#from(SurveyTemplateChangeCommand)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    SurveyTemplateChangeCommand instance = mock(SurveyTemplateChangeCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplateChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).issuanceRole();
    verify(instance).targetEntityKind();
    ImmutableSurveyTemplateChangeCommand buildResult = builderResult.build();
    assertEquals("Issuance Role", buildResult.issuanceRole());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.targetEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#from(SurveyTemplateChangeCommand)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    SurveyTemplateChangeCommand instance = mock(SurveyTemplateChangeCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplateChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).issuanceRole();
    verify(instance).targetEntityKind();
    ImmutableSurveyTemplateChangeCommand buildResult = builderResult.build();
    assertEquals("Issuance Role", buildResult.issuanceRole());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.targetEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Builder#targetEntityKind(EntityKind)}
   */
  @Test
  void testBuilderTargetEntityKind() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetEntityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand#copyOf(SurveyTemplateChangeCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyTemplateChangeCommand instance = mock(SurveyTemplateChangeCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplateChangeCommand actualCopyOfResult = ImmutableSurveyTemplateChangeCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).issuanceRole();
    verify(instance).targetEntityKind();
    assertEquals("Issuance Role", actualCopyOfResult.issuanceRole());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand#copyOf(SurveyTemplateChangeCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SurveyTemplateChangeCommand instance = mock(SurveyTemplateChangeCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplateChangeCommand actualCopyOfResult = ImmutableSurveyTemplateChangeCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).issuanceRole();
    verify(instance).targetEntityKind();
    assertEquals("Issuance Role", actualCopyOfResult.issuanceRole());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand#copyOf(SurveyTemplateChangeCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    SurveyTemplateChangeCommand instance = mock(SurveyTemplateChangeCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplateChangeCommand actualCopyOfResult = ImmutableSurveyTemplateChangeCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).issuanceRole();
    verify(instance).targetEntityKind();
    assertEquals("Issuance Role", actualCopyOfResult.issuanceRole());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand#fromJson(ImmutableSurveyTemplateChangeCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand.Json json = new ImmutableSurveyTemplateChangeCommand.Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setTargetEntityKind(EntityKind.ALL);
    json.setIssuanceRole(null);

    // Act
    ImmutableSurveyTemplateChangeCommand actualFromJsonResult = ImmutableSurveyTemplateChangeCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertNull(actualFromJsonResult.issuanceRole());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetEntityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyTemplateChangeCommand.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyTemplateChangeCommand.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplateChangeCommand.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyTemplateChangeCommand.Json()).id());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Json#issuanceRole()}
   */
  @Test
  void testJsonIssuanceRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyTemplateChangeCommand.Json()).issuanceRole());
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplateChangeCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyTemplateChangeCommand.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyTemplateChangeCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyTemplateChangeCommand.Json actualJson = new ImmutableSurveyTemplateChangeCommand.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.issuanceRole);
    assertNull(actualJson.name);
    assertNull(actualJson.targetEntityKind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplateChangeCommand.Json#targetEntityKind()}
   */
  @Test
  void testJsonTargetEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyTemplateChangeCommand.Json()).targetEntityKind());
  }
}
