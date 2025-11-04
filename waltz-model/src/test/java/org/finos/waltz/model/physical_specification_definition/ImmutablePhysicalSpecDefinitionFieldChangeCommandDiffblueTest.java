package org.finos.waltz.model.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.FieldDataType;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecDefinitionFieldChangeCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#builder()}
   *   <li>
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder actualIdResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder actualLogicalDataElementIdResult = actualIdResult.id(id)
        .logicalDataElementId(1L);
    Optional<Long> logicalDataElementId = Optional.<Long>of(1L);

    // Assert
    assertSame(actualLogicalDataElementIdResult,
        actualLogicalDataElementIdResult.logicalDataElementId(logicalDataElementId));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#from(PhysicalSpecDefinitionFieldChangeCommand)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();
    PhysicalSpecDefinitionFieldChangeCommand instance = mock(PhysicalSpecDefinitionFieldChangeCommand.class);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.logicalDataElementId()).thenReturn(ofResult2);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).logicalDataElementId();
    verify(instance).position();
    verify(instance).type();
    ImmutablePhysicalSpecDefinitionFieldChangeCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(FieldDataType.DATE, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#from(PhysicalSpecDefinitionFieldChangeCommand)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();
    PhysicalSpecDefinitionFieldChangeCommand instance = mock(PhysicalSpecDefinitionFieldChangeCommand.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#from(PhysicalSpecDefinitionFieldChangeCommand)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();
    PhysicalSpecDefinitionFieldChangeCommand instance = mock(PhysicalSpecDefinitionFieldChangeCommand.class);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.logicalDataElementId()).thenReturn(ofResult2);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).logicalDataElementId();
    verify(instance).position();
    verify(instance).type();
    ImmutablePhysicalSpecDefinitionFieldChangeCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(FieldDataType.DATE, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#from(PhysicalSpecDefinitionFieldChangeCommand)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();
    PhysicalSpecDefinitionFieldChangeCommand instance = mock(PhysicalSpecDefinitionFieldChangeCommand.class);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.logicalDataElementId()).thenReturn(ofResult);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).logicalDataElementId();
    verify(instance).position();
    verify(instance).type();
    ImmutablePhysicalSpecDefinitionFieldChangeCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(FieldDataType.DATE, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#from(PhysicalSpecDefinitionFieldChangeCommand)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();
    PhysicalSpecDefinitionFieldChangeCommand instance = mock(PhysicalSpecDefinitionFieldChangeCommand.class);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.logicalDataElementId()).thenReturn(emptyResult);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).logicalDataElementId();
    verify(instance).position();
    verify(instance).type();
    ImmutablePhysicalSpecDefinitionFieldChangeCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(FieldDataType.DATE, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#logicalDataElementId(long)}
   */
  @Test
  void testBuilderLogicalDataElementId() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.logicalDataElementId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#logicalDataElementId(Optional)}
   */
  @Test
  void testBuilderLogicalDataElementId2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();
    Optional<Long> logicalDataElementId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.logicalDataElementId(logicalDataElementId));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder#type(FieldDataType)}
   */
  @Test
  void testBuilderType() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.type(FieldDataType.DATE));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#copyOf(PhysicalSpecDefinitionFieldChangeCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalSpecDefinitionFieldChangeCommand instance = mock(PhysicalSpecDefinitionFieldChangeCommand.class);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.logicalDataElementId()).thenReturn(ofResult2);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualCopyOfResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).logicalDataElementId();
    verify(instance).position();
    verify(instance).type();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(FieldDataType.DATE, actualCopyOfResult.type());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#copyOf(PhysicalSpecDefinitionFieldChangeCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    PhysicalSpecDefinitionFieldChangeCommand instance = mock(PhysicalSpecDefinitionFieldChangeCommand.class);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.logicalDataElementId()).thenReturn(ofResult);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualCopyOfResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).logicalDataElementId();
    verify(instance).position();
    verify(instance).type();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(FieldDataType.DATE, actualCopyOfResult.type());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#copyOf(PhysicalSpecDefinitionFieldChangeCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    PhysicalSpecDefinitionFieldChangeCommand instance = mock(PhysicalSpecDefinitionFieldChangeCommand.class);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.logicalDataElementId()).thenReturn(emptyResult);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualCopyOfResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).logicalDataElementId();
    verify(instance).position();
    verify(instance).type();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(FieldDataType.DATE, actualCopyOfResult.type());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json()).id());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json#logicalDataElementId()}
   */
  @Test
  void testJsonLogicalDataElementId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json()).logicalDataElementId());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json actualJson = new ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.type);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.logicalDataElementId.isPresent());
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json()).position());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json json = new ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json#type()}
   */
  @Test
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json()).type());
  }
}
