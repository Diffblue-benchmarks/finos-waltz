package org.finos.waltz.model.entity_svg_diagram;

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
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableEntitySvgDiagramDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntitySvgDiagram#builder()}
   *   <li>{@link ImmutableEntitySvgDiagram#description(String)}
   *   <li>{@link ImmutableEntitySvgDiagram#externalId(String)}
   *   <li>{@link ImmutableEntitySvgDiagram#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableEntitySvgDiagram.Builder actualExternalIdResult = ImmutableEntitySvgDiagram.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableEntitySvgDiagram.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableEntitySvgDiagram.Builder actualIdResult2 = actualIdResult.id(id);

    // Assert
    assertSame(actualIdResult2, actualIdResult2.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySvgDiagram.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySvgDiagram.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySvgDiagram.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableEntitySvgDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySvgDiagram.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableEntitySvgDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySvgDiagram.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySvgDiagram.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableEntitySvgDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySvgDiagram.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableEntitySvgDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySvgDiagram.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableEntitySvgDiagram.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableEntitySvgDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEntitySvgDiagram.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableEntitySvgDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEntitySvgDiagram.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySvgDiagram.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntitySvgDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySvgDiagram.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntitySvgDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySvgDiagram.Builder#from(EntitySvgDiagram)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();
    EntitySvgDiagram instance = mock(EntitySvgDiagram.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.svg()).thenReturn("Svg");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).svg();
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySvgDiagram.Builder#from(EntitySvgDiagram)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();
    EntitySvgDiagram instance = mock(EntitySvgDiagram.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.svg()).thenReturn("Svg");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).svg();
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySvgDiagram.Builder#from(EntitySvgDiagram)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();
    EntitySvgDiagram instance = mock(EntitySvgDiagram.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.svg()).thenReturn("Svg");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntitySvgDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).svg();
    ImmutableEntitySvgDiagram buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("Svg", buildResult.svg());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySvgDiagram.Builder#from(EntitySvgDiagram)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();
    EntitySvgDiagram instance = mock(EntitySvgDiagram.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.svg()).thenReturn("Svg");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntitySvgDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).svg();
    ImmutableEntitySvgDiagram buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("Svg", buildResult.svg());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySvgDiagram.Builder#from(EntitySvgDiagram)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();
    EntitySvgDiagram instance = mock(EntitySvgDiagram.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.svg()).thenReturn("Svg");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).svg();
  }

  /**
   * Method under test: {@link ImmutableEntitySvgDiagram.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableEntitySvgDiagram.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableEntitySvgDiagram.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableEntitySvgDiagram.Builder#svg(String)}
   */
  @Test
  void testBuilderSvg() {
    // Arrange
    ImmutableEntitySvgDiagram.Builder builderResult = ImmutableEntitySvgDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.svg("Svg"));
  }

  /**
   * Method under test: {@link ImmutableEntitySvgDiagram#copyOf(EntitySvgDiagram)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntitySvgDiagram instance = mock(EntitySvgDiagram.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.svg()).thenReturn("Svg");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntitySvgDiagram actualCopyOfResult = ImmutableEntitySvgDiagram.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).svg();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Svg", actualCopyOfResult.svg());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Method under test: {@link ImmutableEntitySvgDiagram#copyOf(EntitySvgDiagram)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    EntitySvgDiagram instance = mock(EntitySvgDiagram.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.svg()).thenReturn("Svg");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntitySvgDiagram actualCopyOfResult = ImmutableEntitySvgDiagram.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).svg();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Svg", actualCopyOfResult.svg());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Method under test: {@link ImmutableEntitySvgDiagram#copyOf(EntitySvgDiagram)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    EntitySvgDiagram instance = mock(EntitySvgDiagram.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.svg()).thenReturn("Svg");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntitySvgDiagram actualCopyOfResult = ImmutableEntitySvgDiagram.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).svg();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Svg", actualCopyOfResult.svg());
    assertNull(actualCopyOfResult.description());
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySvgDiagram#fromJson(ImmutableEntitySvgDiagram.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableEntitySvgDiagram.Json json = new ImmutableEntitySvgDiagram.Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setProvenance(null);
    json.setExternalId(null);
    json.setSvg("Json");
    json.setEntityReference(mock(EntityReference.class));

    // Act
    ImmutableEntitySvgDiagram actualFromJsonResult = ImmutableEntitySvgDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.svg());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySvgDiagram#fromJson(ImmutableEntitySvgDiagram.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableEntitySvgDiagram.Json json = new ImmutableEntitySvgDiagram.Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setProvenance("Json");
    json.setExternalId(null);
    json.setSvg("Json");
    json.setEntityReference(mock(EntityReference.class));

    // Act
    ImmutableEntitySvgDiagram actualFromJsonResult = ImmutableEntitySvgDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals("Json", actualFromJsonResult.svg());
    assertNull(actualFromJsonResult.description());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test: {@link ImmutableEntitySvgDiagram.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntitySvgDiagram.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableEntitySvgDiagram.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntitySvgDiagram.Json()).entityReference());
  }

  /**
   * Method under test: {@link ImmutableEntitySvgDiagram.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntitySvgDiagram.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableEntitySvgDiagram.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntitySvgDiagram.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableEntitySvgDiagram.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntitySvgDiagram.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEntitySvgDiagram.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntitySvgDiagram.Json actualJson = new ImmutableEntitySvgDiagram.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.svg);
    assertNull(actualJson.entityReference);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test: {@link ImmutableEntitySvgDiagram.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntitySvgDiagram.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableEntitySvgDiagram.Json#svg()}
   */
  @Test
  void testJsonSvg() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntitySvgDiagram.Json()).svg());
  }
}
