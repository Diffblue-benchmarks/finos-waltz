package org.finos.waltz.model.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecDefinitionChangeCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionChangeCommand#builder()}
   *   <li>{@link ImmutablePhysicalSpecDefinitionChangeCommand#delimiter(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder actualDelimiterResult = ImmutablePhysicalSpecDefinitionChangeCommand
        .builder()
        .delimiter("Delimiter");
    Optional<String> delimiter = Optional.of("foo");
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder actualIdResult = actualDelimiterResult.delimiter(delimiter)
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Builder#delimiter(Optional)}
   */
  @Test
  void testBuilderDelimiter() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand
        .builder();
    Optional<String> delimiter = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.delimiter(delimiter));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand
        .builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand
        .builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand
        .builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Builder#from(PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand
        .builder();
    PhysicalSpecDefinitionChangeCommand instance = mock(PhysicalSpecDefinitionChangeCommand.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.delimiter()).thenReturn(ofResult);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).delimiter();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
    ImmutablePhysicalSpecDefinitionChangeCommand buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Builder#from(PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand
        .builder();
    PhysicalSpecDefinitionChangeCommand instance = mock(PhysicalSpecDefinitionChangeCommand.class);
    when(instance.delimiter()).thenThrow(new IllegalStateException("instance"));
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).delimiter();
    verify(instance).type();
    verify(instance).version();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Builder#from(PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand
        .builder();
    PhysicalSpecDefinitionChangeCommand instance = mock(PhysicalSpecDefinitionChangeCommand.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.delimiter()).thenReturn(emptyResult);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).delimiter();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
    ImmutablePhysicalSpecDefinitionChangeCommand buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Builder#from(PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand
        .builder();
    PhysicalSpecDefinitionChangeCommand instance = mock(PhysicalSpecDefinitionChangeCommand.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.delimiter()).thenReturn(ofResult);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).delimiter();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
    ImmutablePhysicalSpecDefinitionChangeCommand buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand
        .builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Builder#status(ReleaseLifecycleStatus)}
   */
  @Test
  void testBuilderStatus() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.status(ReleaseLifecycleStatus.DRAFT));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Builder#type(PhysicalSpecDefinitionType)}
   */
  @Test
  void testBuilderType() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.type(PhysicalSpecDefinitionType.DELIMITED));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Builder#version(String)}
   */
  @Test
  void testBuilderVersion() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.version("1.0.2"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand#copyOf(PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalSpecDefinitionChangeCommand instance = mock(PhysicalSpecDefinitionChangeCommand.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.delimiter()).thenReturn(ofResult);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualCopyOfResult = ImmutablePhysicalSpecDefinitionChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).delimiter();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
    assertEquals("1.0.2", actualCopyOfResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualCopyOfResult.type());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand#copyOf(PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    PhysicalSpecDefinitionChangeCommand instance = mock(PhysicalSpecDefinitionChangeCommand.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.delimiter()).thenReturn(emptyResult);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualCopyOfResult = ImmutablePhysicalSpecDefinitionChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).delimiter();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
    assertEquals("1.0.2", actualCopyOfResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualCopyOfResult.type());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand#copyOf(PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    PhysicalSpecDefinitionChangeCommand instance = mock(PhysicalSpecDefinitionChangeCommand.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.delimiter()).thenReturn(ofResult);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualCopyOfResult = ImmutablePhysicalSpecDefinitionChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).delimiter();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
    assertEquals("1.0.2", actualCopyOfResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualCopyOfResult.type());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand#fromJson(ImmutablePhysicalSpecDefinitionChangeCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand.Json json = new ImmutablePhysicalSpecDefinitionChangeCommand.Json();
    json.setId(null);
    json.setVersion("Json");
    json.setStatus(ReleaseLifecycleStatus.DRAFT);
    json.setDelimiter(null);
    json.setType(PhysicalSpecDefinitionType.DELIMITED);

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualFromJsonResult = ImmutablePhysicalSpecDefinitionChangeCommand
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualFromJsonResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualFromJsonResult.type());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Json#delimiter()}
   */
  @Test
  void testJsonDelimiter() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionChangeCommand.Json()).delimiter());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionChangeCommand.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionChangeCommand.Json actualJson = new ImmutablePhysicalSpecDefinitionChangeCommand.Json();

    // Assert
    assertNull(actualJson.version);
    assertNull(actualJson.status);
    assertNull(actualJson.type);
    assertFalse(actualJson.delimiter.isPresent());
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Json#status()}
   */
  @Test
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionChangeCommand.Json()).status());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Json#type()}
   */
  @Test
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionChangeCommand.Json()).type());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionChangeCommand.Json#version()}
   */
  @Test
  void testJsonVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionChangeCommand.Json()).version());
  }
}
