package org.finos.waltz.web.json;

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

class ImmutableReportGridColumnJSONDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridColumnJSON#builder()}
   *   <li>{@link ImmutableReportGridColumnJSON#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableReportGridColumnJSON.Builder actualIdResult = ImmutableReportGridColumnJSON.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnJSON.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportGridColumnJSON.Builder builderResult = ImmutableReportGridColumnJSON.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableReportGridColumnJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnJSON.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableReportGridColumnJSON.Builder builderResult = ImmutableReportGridColumnJSON.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableReportGridColumnJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnJSON.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableReportGridColumnJSON.Builder builderResult = ImmutableReportGridColumnJSON.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnJSON.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableReportGridColumnJSON.Builder builderResult = ImmutableReportGridColumnJSON.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableReportGridColumnJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnJSON.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableReportGridColumnJSON.Builder builderResult = ImmutableReportGridColumnJSON.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableReportGridColumnJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnJSON.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableReportGridColumnJSON.Builder builderResult = ImmutableReportGridColumnJSON.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnJSON.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableReportGridColumnJSON.Builder builderResult = ImmutableReportGridColumnJSON.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridColumnJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnJSON.Builder#from(ReportGridDefinitionJSON.ReportGridColumnJSON)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableReportGridColumnJSON.Builder builderResult = ImmutableReportGridColumnJSON.builder();
    ReportGridDefinitionJSON.ReportGridColumnJSON instance = mock(ReportGridDefinitionJSON.ReportGridColumnJSON.class);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridColumnJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).position();
    ImmutableReportGridColumnJSON buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnJSON.Builder#from(ReportGridDefinitionJSON.ReportGridColumnJSON)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableReportGridColumnJSON.Builder builderResult = ImmutableReportGridColumnJSON.builder();
    ReportGridDefinitionJSON.ReportGridColumnJSON instance = mock(ReportGridDefinitionJSON.ReportGridColumnJSON.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnJSON.Builder#from(ReportGridDefinitionJSON.ReportGridColumnJSON)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableReportGridColumnJSON.Builder builderResult = ImmutableReportGridColumnJSON.builder();
    ReportGridDefinitionJSON.ReportGridColumnJSON instance = mock(ReportGridDefinitionJSON.ReportGridColumnJSON.class);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridColumnJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).position();
    ImmutableReportGridColumnJSON buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(1, buildResult.position());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnJSON.Builder#from(ReportGridDefinitionJSON.ReportGridColumnJSON)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableReportGridColumnJSON.Builder builderResult = ImmutableReportGridColumnJSON.builder();
    ReportGridDefinitionJSON.ReportGridColumnJSON instance = mock(ReportGridDefinitionJSON.ReportGridColumnJSON.class);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridColumnJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).position();
    ImmutableReportGridColumnJSON buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableReportGridColumnJSON.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableReportGridColumnJSON.Builder builderResult = ImmutableReportGridColumnJSON.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableReportGridColumnJSON.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableReportGridColumnJSON.Builder builderResult = ImmutableReportGridColumnJSON.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableReportGridColumnJSON.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableReportGridColumnJSON.Builder builderResult = ImmutableReportGridColumnJSON.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnJSON.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutableReportGridColumnJSON.Builder builderResult = ImmutableReportGridColumnJSON.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnJSON#copyOf(ReportGridDefinitionJSON.ReportGridColumnJSON)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportGridDefinitionJSON.ReportGridColumnJSON instance = mock(ReportGridDefinitionJSON.ReportGridColumnJSON.class);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridColumnJSON actualCopyOfResult = ImmutableReportGridColumnJSON.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).position();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnJSON#copyOf(ReportGridDefinitionJSON.ReportGridColumnJSON)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ReportGridDefinitionJSON.ReportGridColumnJSON instance = mock(ReportGridDefinitionJSON.ReportGridColumnJSON.class);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridColumnJSON actualCopyOfResult = ImmutableReportGridColumnJSON.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).position();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
  }

  /**
   * Method under test: {@link ImmutableReportGridColumnJSON.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridColumnJSON.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableReportGridColumnJSON.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridColumnJSON.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableReportGridColumnJSON.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridColumnJSON.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableReportGridColumnJSON.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableReportGridColumnJSON.Json actualJson = new ImmutableReportGridColumnJSON.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Method under test: {@link ImmutableReportGridColumnJSON.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridColumnJSON.Json()).position());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnJSON.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutableReportGridColumnJSON.Json json = new ImmutableReportGridColumnJSON.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }
}
