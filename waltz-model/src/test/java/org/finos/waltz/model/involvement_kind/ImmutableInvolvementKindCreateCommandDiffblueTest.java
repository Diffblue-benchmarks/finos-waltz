package org.finos.waltz.model.involvement_kind;

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

class ImmutableInvolvementKindCreateCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableInvolvementKindCreateCommand#builder()}
   *   <li>{@link ImmutableInvolvementKindCreateCommand#description(String)}
   *   <li>{@link ImmutableInvolvementKindCreateCommand#externalId(String)}
   *   <li>{@link ImmutableInvolvementKindCreateCommand#permittedRole(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableInvolvementKindCreateCommand.Builder actualExternalIdResult = ImmutableInvolvementKindCreateCommand
        .builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableInvolvementKindCreateCommand.Builder actualExternalIdResult2 = actualExternalIdResult
        .externalId(externalId);

    // Assert
    assertSame(actualExternalIdResult2, actualExternalIdResult2.permittedRole("Permitted Role"));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableInvolvementKindCreateCommand.Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableInvolvementKindCreateCommand.Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableInvolvementKindCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableInvolvementKindCreateCommand.Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableInvolvementKindCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableInvolvementKindCreateCommand.Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableInvolvementKindCreateCommand.Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableInvolvementKindCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableInvolvementKindCreateCommand.Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableInvolvementKindCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableInvolvementKindCreateCommand.Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableInvolvementKindCreateCommand.Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKindCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableInvolvementKindCreateCommand.Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Builder#from(InvolvementKindCreateCommand)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableInvolvementKindCreateCommand.Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    InvolvementKindCreateCommand instance = mock(InvolvementKindCreateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.permittedRole()).thenReturn("Permitted Role");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKindCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).permittedRole();
    verify(instance).subjectKind();
    ImmutableInvolvementKindCreateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Permitted Role", buildResult.permittedRole());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Builder#from(InvolvementKindCreateCommand)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableInvolvementKindCreateCommand.Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    InvolvementKindCreateCommand instance = mock(InvolvementKindCreateCommand.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Builder#from(InvolvementKindCreateCommand)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableInvolvementKindCreateCommand.Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    InvolvementKindCreateCommand instance = mock(InvolvementKindCreateCommand.class);
    when(instance.description()).thenReturn(null);
    when(instance.permittedRole()).thenReturn("Permitted Role");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKindCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).permittedRole();
    verify(instance).subjectKind();
    ImmutableInvolvementKindCreateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Permitted Role", buildResult.permittedRole());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Builder#from(InvolvementKindCreateCommand)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableInvolvementKindCreateCommand.Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    InvolvementKindCreateCommand instance = mock(InvolvementKindCreateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.permittedRole()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKindCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).permittedRole();
    verify(instance).subjectKind();
    ImmutableInvolvementKindCreateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.permittedRole());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Builder#from(InvolvementKindCreateCommand)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableInvolvementKindCreateCommand.Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    InvolvementKindCreateCommand instance = mock(InvolvementKindCreateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.permittedRole()).thenReturn("Permitted Role");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKindCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).permittedRole();
    verify(instance).subjectKind();
    ImmutableInvolvementKindCreateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Permitted Role", buildResult.permittedRole());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableInvolvementKindCreateCommand.Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Builder#subjectKind(EntityKind)}
   */
  @Test
  void testBuilderSubjectKind() {
    // Arrange
    ImmutableInvolvementKindCreateCommand.Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand#copyOf(InvolvementKindCreateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    InvolvementKindCreateCommand instance = mock(InvolvementKindCreateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.permittedRole()).thenReturn("Permitted Role");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKindCreateCommand actualCopyOfResult = ImmutableInvolvementKindCreateCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).permittedRole();
    verify(instance).subjectKind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Permitted Role", actualCopyOfResult.permittedRole());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand#copyOf(InvolvementKindCreateCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    InvolvementKindCreateCommand instance = mock(InvolvementKindCreateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.permittedRole()).thenReturn("Permitted Role");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKindCreateCommand actualCopyOfResult = ImmutableInvolvementKindCreateCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).permittedRole();
    verify(instance).subjectKind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Permitted Role", actualCopyOfResult.permittedRole());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand#fromJson(ImmutableInvolvementKindCreateCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableInvolvementKindCreateCommand.Json json = new ImmutableInvolvementKindCreateCommand.Json();
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setSubjectKind(EntityKind.ALL);
    json.setPermittedRole(null);

    // Act
    ImmutableInvolvementKindCreateCommand actualFromJsonResult = ImmutableInvolvementKindCreateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertNull(actualFromJsonResult.permittedRole());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInvolvementKindCreateCommand.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInvolvementKindCreateCommand.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableInvolvementKindCreateCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementKindCreateCommand.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableInvolvementKindCreateCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableInvolvementKindCreateCommand.Json actualJson = new ImmutableInvolvementKindCreateCommand.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.permittedRole);
    assertNull(actualJson.subjectKind);
    assertFalse(actualJson.externalId.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Json#permittedRole()}
   */
  @Test
  void testJsonPermittedRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInvolvementKindCreateCommand.Json()).permittedRole());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindCreateCommand.Json#subjectKind()}
   */
  @Test
  void testJsonSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInvolvementKindCreateCommand.Json()).subjectKind());
  }
}
