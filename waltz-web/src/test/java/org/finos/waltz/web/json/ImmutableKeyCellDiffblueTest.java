package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.web.json.ImmutableKeyCell.Builder;
import org.finos.waltz.web.json.ImmutableKeyCell.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableKeyCellDiffblueTest {
  /**
   * Test {@link ImmutableKeyCell#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableKeyCell#builder()}
   *   <li>{@link ImmutableKeyCell#externalId(String)}
   *   <li>{@link ImmutableKeyCell#name(String)}
   *   <li>{@link ImmutableKeyCell#type(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableKeyCell Builder.build()", "Builder Builder.externalId(String)",
      "Builder Builder.name(String)", "Builder Builder.type(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualExternalIdResult = ImmutableKeyCell.builder().externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualNameResult = actualExternalIdResult.externalId(externalId).name("Name");
    Optional<String> name = Optional.of("foo");
    Builder actualWaltzIdResult = actualNameResult.name(name).type("Type").waltzId(1L);
    Optional<Long> waltzId = Optional.<Long>of(1L);

    // Assert
    assertSame(actualWaltzIdResult, actualWaltzIdResult.waltzId(waltzId));
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableKeyCell.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Test Builder {@link Builder#from(KeyCell)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link KeyCell} {@link KeyCell#externalId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(KeyCell)}
   */
  @Test
  @DisplayName("Test Builder from(KeyCell); given empty; when KeyCell externalId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(KeyCell)"})
  void testBuilderFrom_givenEmpty_whenKeyCellExternalIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableKeyCell.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(KeyCell)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link KeyCell} {@link KeyCell#waltzId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(KeyCell)}
   */
  @Test
  @DisplayName("Test Builder from(KeyCell); given empty; when KeyCell waltzId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(KeyCell)"})
  void testBuilderFrom_givenEmpty_whenKeyCellWaltzIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableKeyCell.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(KeyCell)}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   *   <li>When {@link KeyCell} {@link KeyCell#externalId()} return {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(KeyCell)}
   */
  @Test
  @DisplayName("Test Builder from(KeyCell); given Optional with one; when KeyCell externalId() return Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(KeyCell)"})
  void testBuilderFrom_givenOptionalWithOne_whenKeyCellExternalIdReturnOptionalWithFoo() {
    // Arrange
    Builder builderResult = ImmutableKeyCell.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(KeyCell)}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   *   <li>When {@link KeyCell} {@link KeyCell#name()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(KeyCell)}
   */
  @Test
  @DisplayName("Test Builder from(KeyCell); given Optional with one; when KeyCell name() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(KeyCell)"})
  void testBuilderFrom_givenOptionalWithOne_whenKeyCellNameReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableKeyCell.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(KeyCell)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(KeyCell)}
   */
  @Test
  @DisplayName("Test Builder from(KeyCell); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(KeyCell)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableKeyCell.builder();
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
   * Test Builder {@link Builder#kind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#kind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.kind(EntityKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutableKeyCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#lifecyclePhase(LifecyclePhase)}.
   * <p>
   * Method under test: {@link Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test Builder lifecyclePhase(LifecyclePhase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lifecyclePhase(LifecyclePhase)"})
  void testBuilderLifecyclePhase() {
    // Arrange
    Builder builderResult = ImmutableKeyCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Test Builder {@link Builder#name(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#name(Optional)}
   */
  @Test
  @DisplayName("Test Builder name(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(Optional)"})
  void testBuilderNameWithOptional() {
    // Arrange
    Builder builderResult = ImmutableKeyCell.builder();
    Optional<String> name = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.name(name));
  }

  /**
   * Test Builder {@link Builder#waltzId(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#waltzId(long)}
   */
  @Test
  @DisplayName("Test Builder waltzId(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.waltzId(long)"})
  void testBuilderWaltzIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableKeyCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.waltzId(1L));
  }

  /**
   * Test Builder {@link Builder#waltzId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#waltzId(Optional)}
   */
  @Test
  @DisplayName("Test Builder waltzId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.waltzId(Optional)"})
  void testBuilderWaltzIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableKeyCell.builder();
    Optional<Long> waltzId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.waltzId(waltzId));
  }

  /**
   * Test Json {@link Json#externalId()}.
   * <p>
   * Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).externalId());
  }

  /**
   * Test Json {@link Json#kind()}.
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
  }

  /**
   * Test Json {@link Json#lifecyclePhase()}.
   * <p>
   * Method under test: {@link Json#lifecyclePhase()}
   */
  @Test
  @DisplayName("Test Json lifecyclePhase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LifecyclePhase Json.lifecyclePhase()"})
  void testJsonLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lifecyclePhase());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.type);
    assertNull(actualJson.kind);
    assertNull(actualJson.lifecyclePhase);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.name.isPresent());
    assertFalse(actualJson.waltzId.isPresent());
  }

  /**
   * Test Json {@link Json#type()}.
   * <p>
   * Method under test: {@link Json#type()}
   */
  @Test
  @DisplayName("Test Json type()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.type()"})
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).type());
  }

  /**
   * Test Json {@link Json#waltzId()}.
   * <p>
   * Method under test: {@link Json#waltzId()}
   */
  @Test
  @DisplayName("Test Json waltzId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.waltzId()"})
  void testJsonWaltzId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).waltzId());
  }
}
