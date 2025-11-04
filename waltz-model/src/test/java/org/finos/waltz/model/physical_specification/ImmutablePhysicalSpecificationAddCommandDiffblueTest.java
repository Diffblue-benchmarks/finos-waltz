package org.finos.waltz.model.physical_specification;

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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecificationAddCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecificationAddCommand#builder()}
   *   <li>{@link ImmutablePhysicalSpecificationAddCommand#description(String)}
   *   <li>{@link ImmutablePhysicalSpecificationAddCommand#externalId(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutablePhysicalSpecificationAddCommand.Builder actualExternalIdResult = ImmutablePhysicalSpecificationAddCommand
        .builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");

    // Assert
    assertSame(actualExternalIdResult, actualExternalIdResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutablePhysicalSpecificationAddCommand.Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Builder#format(DataFormatKindValue)}
   */
  @Test
  void testBuilderFormat() {
    // Arrange
    ImmutablePhysicalSpecificationAddCommand.Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.format(DataFormatKindValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalSpecificationAddCommand.Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutablePhysicalSpecificationAddCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalSpecificationAddCommand.Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutablePhysicalSpecificationAddCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePhysicalSpecificationAddCommand.Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutablePhysicalSpecificationAddCommand.Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutablePhysicalSpecificationAddCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutablePhysicalSpecificationAddCommand.Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutablePhysicalSpecificationAddCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutablePhysicalSpecificationAddCommand.Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutablePhysicalSpecificationAddCommand.Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecificationAddCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Builder#from(PhysicalSpecificationAddCommand)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutablePhysicalSpecificationAddCommand.Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();
    PhysicalSpecificationAddCommand instance = mock(PhysicalSpecificationAddCommand.class);
    when(instance.owningEntity()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.format()).thenReturn(DataFormatKindValue.of("42"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).format();
    verify(instance).owningEntity();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Builder#from(PhysicalSpecificationAddCommand)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutablePhysicalSpecificationAddCommand.Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();
    PhysicalSpecificationAddCommand instance = mock(PhysicalSpecificationAddCommand.class);
    when(instance.owningEntity()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.format()).thenReturn(DataFormatKindValue.of("42"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).format();
    verify(instance).owningEntity();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Builder#from(PhysicalSpecificationAddCommand)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutablePhysicalSpecificationAddCommand.Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();
    PhysicalSpecificationAddCommand instance = mock(PhysicalSpecificationAddCommand.class);
    when(instance.owningEntity()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    DataFormatKindValue ofResult2 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecificationAddCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).format();
    verify(instance).owningEntity();
    ImmutablePhysicalSpecificationAddCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(ofResult2, buildResult.format());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutablePhysicalSpecificationAddCommand.Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Builder#owningEntity(EntityReference)}
   */
  @Test
  void testBuilderOwningEntity() {
    // Arrange
    ImmutablePhysicalSpecificationAddCommand.Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.owningEntity(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand#copyOf(PhysicalSpecificationAddCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalSpecificationAddCommand instance = mock(PhysicalSpecificationAddCommand.class);
    when(instance.owningEntity()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    DataFormatKindValue ofResult2 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecificationAddCommand actualCopyOfResult = ImmutablePhysicalSpecificationAddCommand
        .copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).format();
    verify(instance).owningEntity();
    DataFormatKindValue formatResult = actualCopyOfResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertSame(ofResult2, formatResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand#fromJson(ImmutablePhysicalSpecificationAddCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutablePhysicalSpecificationAddCommand.Json json = new ImmutablePhysicalSpecificationAddCommand.Json();
    DataFormatKindValue format = DataFormatKindValue.of("42");
    json.setFormat(format);
    json.setName("owningEntity");
    json.setOwningEntity(mock(EntityReference.class));

    // Act
    ImmutablePhysicalSpecificationAddCommand actualFromJsonResult = ImmutablePhysicalSpecificationAddCommand
        .fromJson(json);

    // Assert
    DataFormatKindValue formatResult = actualFromJsonResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("owningEntity", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertSame(format, formatResult);
    EntityReference expectedOwningEntityResult = json.owningEntity;
    assertSame(expectedOwningEntityResult, actualFromJsonResult.owningEntity());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecificationAddCommand.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecificationAddCommand.Json()).externalId());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Json#format()}
   */
  @Test
  void testJsonFormat() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecificationAddCommand.Json()).format());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecificationAddCommand.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePhysicalSpecificationAddCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePhysicalSpecificationAddCommand.Json actualJson = new ImmutablePhysicalSpecificationAddCommand.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.owningEntity);
    assertNull(actualJson.format);
    assertFalse(actualJson.externalId.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecificationAddCommand.Json#owningEntity()}
   */
  @Test
  void testJsonOwningEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecificationAddCommand.Json()).owningEntity());
  }
}
