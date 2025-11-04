package org.finos.waltz.model.flow_diagram;

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
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableFlowDiagramOverlayGroupDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowDiagramOverlayGroup#builder()}
   *   <li>{@link ImmutableFlowDiagramOverlayGroup#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableFlowDiagramOverlayGroup.Builder actualIdResult = ImmutableFlowDiagramOverlayGroup.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup.Builder#diagramId(Long)}
   */
  @Test
  void testBuilderDiagramId() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup.Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup.Builder#externalId(String)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup.Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup.Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableFlowDiagramOverlayGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup.Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableFlowDiagramOverlayGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup.Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup.Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableFlowDiagramOverlayGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup.Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableFlowDiagramOverlayGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup.Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup.Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowDiagramOverlayGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup.Builder#from(FlowDiagramOverlayGroup)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup.Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();
    FlowDiagramOverlayGroup instance = mock(FlowDiagramOverlayGroup.class);
    when(instance.diagramId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isDefault()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowDiagramOverlayGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).diagramId();
    verify(instance).externalId();
    verify(instance).isDefault();
    ImmutableFlowDiagramOverlayGroup buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.diagramId().longValue());
    assertTrue(buildResult.isDefault());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup.Builder#from(FlowDiagramOverlayGroup)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup.Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();
    FlowDiagramOverlayGroup instance = mock(FlowDiagramOverlayGroup.class);
    when(instance.diagramId()).thenReturn(1L);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.isDefault()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowDiagramOverlayGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).diagramId();
    verify(instance).externalId();
    verify(instance).isDefault();
    ImmutableFlowDiagramOverlayGroup buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.diagramId().longValue());
    assertTrue(buildResult.isDefault());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup.Builder#from(FlowDiagramOverlayGroup)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup.Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();
    FlowDiagramOverlayGroup instance = mock(FlowDiagramOverlayGroup.class);
    when(instance.diagramId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isDefault()).thenReturn(true);
    when(instance.description()).thenReturn(null);
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowDiagramOverlayGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).diagramId();
    verify(instance).externalId();
    verify(instance).isDefault();
    ImmutableFlowDiagramOverlayGroup buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.diagramId().longValue());
    assertTrue(buildResult.isDefault());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFlowDiagramOverlayGroup.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup.Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup.Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup.Builder#isDefault(boolean)}
   */
  @Test
  void testBuilderIsDefault() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup.Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isDefault(true));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup.Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup#copyOf(FlowDiagramOverlayGroup)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowDiagramOverlayGroup instance = mock(FlowDiagramOverlayGroup.class);
    when(instance.diagramId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isDefault()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowDiagramOverlayGroup actualCopyOfResult = ImmutableFlowDiagramOverlayGroup.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).diagramId();
    verify(instance).externalId();
    verify(instance).isDefault();
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.diagramId().longValue());
    assertTrue(actualCopyOfResult.isDefault());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup#copyOf(FlowDiagramOverlayGroup)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    FlowDiagramOverlayGroup instance = mock(FlowDiagramOverlayGroup.class);
    when(instance.diagramId()).thenReturn(1L);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.isDefault()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowDiagramOverlayGroup actualCopyOfResult = ImmutableFlowDiagramOverlayGroup.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).diagramId();
    verify(instance).externalId();
    verify(instance).isDefault();
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.diagramId().longValue());
    assertTrue(actualCopyOfResult.isDefault());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup#copyOf(FlowDiagramOverlayGroup)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    FlowDiagramOverlayGroup instance = mock(FlowDiagramOverlayGroup.class);
    when(instance.diagramId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isDefault()).thenReturn(false);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowDiagramOverlayGroup actualCopyOfResult = ImmutableFlowDiagramOverlayGroup.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).diagramId();
    verify(instance).externalId();
    verify(instance).isDefault();
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.diagramId().longValue());
    assertFalse(actualCopyOfResult.isDefault());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowDiagramOverlayGroup.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagramOverlayGroup.Json#diagramId()}
   */
  @Test
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagramOverlayGroup.Json()).diagramId());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagramOverlayGroup.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagramOverlayGroup.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagramOverlayGroup.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagramOverlayGroup.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagramOverlayGroup.Json#isDefault()}
   */
  @Test
  void testJsonIsDefault() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagramOverlayGroup.Json()).isDefault());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagramOverlayGroup.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagramOverlayGroup.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableFlowDiagramOverlayGroup.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableFlowDiagramOverlayGroup.Json actualJson = new ImmutableFlowDiagramOverlayGroup.Json();

    // Assert
    assertNull(actualJson.diagramId);
    assertNull(actualJson.description);
    assertNull(actualJson.externalId);
    assertNull(actualJson.name);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isDefault);
    assertFalse(actualJson.isDefaultIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagramOverlayGroup.Json#setIsDefault(boolean)}
   */
  @Test
  void testJsonSetIsDefault() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup.Json json = new ImmutableFlowDiagramOverlayGroup.Json();

    // Act
    json.setIsDefault(true);

    // Assert
    assertTrue(json.isDefault);
    assertTrue(json.isDefaultIsSet);
  }
}
