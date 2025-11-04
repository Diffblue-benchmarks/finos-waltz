package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.application.LifecyclePhase;
import org.junit.jupiter.api.Test;

class ImmutableKeyCellDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableKeyCell#builder()}
   *   <li>{@link ImmutableKeyCell#externalId(String)}
   *   <li>{@link ImmutableKeyCell#name(String)}
   *   <li>{@link ImmutableKeyCell#type(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableKeyCell.Builder actualExternalIdResult = ImmutableKeyCell.builder().externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableKeyCell.Builder actualNameResult = actualExternalIdResult.externalId(externalId).name("Name");
    Optional<String> name = Optional.of("foo");
    ImmutableKeyCell.Builder actualWaltzIdResult = actualNameResult.name(name).type("Type").waltzId(1L);
    Optional<Long> waltzId = Optional.<Long>of(1L);

    // Assert
    assertSame(actualWaltzIdResult, actualWaltzIdResult.waltzId(waltzId));
  }

  /**
   * Method under test: {@link ImmutableKeyCell.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableKeyCell.Builder builderResult = ImmutableKeyCell.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test: {@link ImmutableKeyCell.Builder#from(KeyCell)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableKeyCell.Builder builderResult = ImmutableKeyCell.builder();
    KeyCell instance = mock(KeyCell.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.waltzId()).thenReturn(ofResult2);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.type()).thenReturn("Type");

    // Act
    ImmutableKeyCell.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).name();
    verify(instance).type();
    verify(instance).waltzId();
    ImmutableKeyCell buildResult = builderResult.build();
    assertEquals("Type", buildResult.type());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableKeyCell.Builder#from(KeyCell)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableKeyCell.Builder builderResult = ImmutableKeyCell.builder();
    KeyCell instance = mock(KeyCell.class);
    when(instance.waltzId()).thenThrow(new IllegalStateException("instance"));
    Optional<String> ofResult = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.type()).thenReturn("Type");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
    verify(instance).name();
    verify(instance).type();
    verify(instance).waltzId();
  }

  /**
   * Method under test: {@link ImmutableKeyCell.Builder#from(KeyCell)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableKeyCell.Builder builderResult = ImmutableKeyCell.builder();
    KeyCell instance = mock(KeyCell.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.waltzId()).thenReturn(ofResult);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.type()).thenReturn("Type");

    // Act
    ImmutableKeyCell.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).name();
    verify(instance).type();
    verify(instance).waltzId();
    ImmutableKeyCell buildResult = builderResult.build();
    assertEquals("Type", buildResult.type());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableKeyCell.Builder#from(KeyCell)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableKeyCell.Builder builderResult = ImmutableKeyCell.builder();
    KeyCell instance = mock(KeyCell.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.waltzId()).thenReturn(emptyResult);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.type()).thenReturn("Type");

    // Act
    ImmutableKeyCell.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).name();
    verify(instance).type();
    verify(instance).waltzId();
    ImmutableKeyCell buildResult = builderResult.build();
    assertEquals("Type", buildResult.type());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableKeyCell.Builder#from(KeyCell)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableKeyCell.Builder builderResult = ImmutableKeyCell.builder();
    KeyCell instance = mock(KeyCell.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.waltzId()).thenReturn(ofResult2);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Optional<String> emptyResult = Optional.empty();
    when(instance.name()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.type()).thenReturn("Type");

    // Act
    ImmutableKeyCell.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).name();
    verify(instance).type();
    verify(instance).waltzId();
    ImmutableKeyCell buildResult = builderResult.build();
    assertEquals("Type", buildResult.type());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableKeyCell.Builder#kind(EntityKind)}
   */
  @Test
  void testBuilderKind() {
    // Arrange
    ImmutableKeyCell.Builder builderResult = ImmutableKeyCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableKeyCell.Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  void testBuilderLifecyclePhase() {
    // Arrange
    ImmutableKeyCell.Builder builderResult = ImmutableKeyCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Method under test: {@link ImmutableKeyCell.Builder#name(Optional)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableKeyCell.Builder builderResult = ImmutableKeyCell.builder();
    Optional<String> name = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.name(name));
  }

  /**
   * Method under test: {@link ImmutableKeyCell.Builder#waltzId(long)}
   */
  @Test
  void testBuilderWaltzId() {
    // Arrange
    ImmutableKeyCell.Builder builderResult = ImmutableKeyCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.waltzId(1L));
  }

  /**
   * Method under test: {@link ImmutableKeyCell.Builder#waltzId(Optional)}
   */
  @Test
  void testBuilderWaltzId2() {
    // Arrange
    ImmutableKeyCell.Builder builderResult = ImmutableKeyCell.builder();
    Optional<Long> waltzId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.waltzId(waltzId));
  }

  /**
   * Method under test: {@link ImmutableKeyCell#copyOf(KeyCell)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    KeyCell instance = mock(KeyCell.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.waltzId()).thenReturn(ofResult2);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.type()).thenReturn("Type");

    // Act
    ImmutableKeyCell actualCopyOfResult = ImmutableKeyCell.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).name();
    verify(instance).type();
    verify(instance).waltzId();
    assertEquals("Type", actualCopyOfResult.type());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
  }

  /**
   * Method under test: {@link ImmutableKeyCell#copyOf(KeyCell)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    KeyCell instance = mock(KeyCell.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.waltzId()).thenReturn(ofResult);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.type()).thenReturn("Type");

    // Act
    ImmutableKeyCell actualCopyOfResult = ImmutableKeyCell.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).name();
    verify(instance).type();
    verify(instance).waltzId();
    assertEquals("Type", actualCopyOfResult.type());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
  }

  /**
   * Method under test: {@link ImmutableKeyCell#copyOf(KeyCell)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    KeyCell instance = mock(KeyCell.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.waltzId()).thenReturn(emptyResult);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.type()).thenReturn("Type");

    // Act
    ImmutableKeyCell actualCopyOfResult = ImmutableKeyCell.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).name();
    verify(instance).type();
    verify(instance).waltzId();
    assertEquals("Type", actualCopyOfResult.type());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
  }

  /**
   * Method under test: {@link ImmutableKeyCell#copyOf(KeyCell)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    KeyCell instance = mock(KeyCell.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.waltzId()).thenReturn(ofResult2);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Optional<String> emptyResult = Optional.empty();
    when(instance.name()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.type()).thenReturn("Type");

    // Act
    ImmutableKeyCell actualCopyOfResult = ImmutableKeyCell.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).name();
    verify(instance).type();
    verify(instance).waltzId();
    assertEquals("Type", actualCopyOfResult.type());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
  }

  /**
   * Method under test: {@link ImmutableKeyCell#fromJson(ImmutableKeyCell.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableKeyCell.Json json = new ImmutableKeyCell.Json();
    json.setType(null);
    json.setName(null);
    json.setKind(EntityKind.ALL);
    json.setWaltzId(null);
    json.setExternalId(null);
    json.setLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Act
    ImmutableKeyCell actualFromJsonResult = ImmutableKeyCell.fromJson(json);

    // Assert
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualFromJsonResult.lifecyclePhase());
    assertEquals(ApiTypes.KEYCELL, actualFromJsonResult.type());
  }

  /**
   * Method under test: {@link ImmutableKeyCell#fromJson(ImmutableKeyCell.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableKeyCell.Json json = new ImmutableKeyCell.Json();
    json.setType("Json");
    json.setName(null);
    json.setKind(EntityKind.ALL);
    json.setWaltzId(null);
    json.setExternalId(null);
    json.setLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Act
    ImmutableKeyCell actualFromJsonResult = ImmutableKeyCell.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.type());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualFromJsonResult.lifecyclePhase());
  }

  /**
   * Method under test: {@link ImmutableKeyCell.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableKeyCell.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableKeyCell.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableKeyCell.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableKeyCell.Json#lifecyclePhase()}
   */
  @Test
  void testJsonLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableKeyCell.Json()).lifecyclePhase());
  }

  /**
   * Method under test: {@link ImmutableKeyCell.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableKeyCell.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableKeyCell.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableKeyCell.Json actualJson = new ImmutableKeyCell.Json();

    // Assert
    assertNull(actualJson.type);
    assertNull(actualJson.kind);
    assertNull(actualJson.lifecyclePhase);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.name.isPresent());
    assertFalse(actualJson.waltzId.isPresent());
  }

  /**
   * Method under test: {@link ImmutableKeyCell.Json#type()}
   */
  @Test
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableKeyCell.Json()).type());
  }

  /**
   * Method under test: {@link ImmutableKeyCell.Json#waltzId()}
   */
  @Test
  void testJsonWaltzId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableKeyCell.Json()).waltzId());
  }
}
