package org.finos.waltz.model.scenario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.AxisOrientation;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.scenario.ImmutableScenarioAxisItem.Builder;
import org.finos.waltz.model.scenario.ImmutableScenarioAxisItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableScenarioAxisItemDiffblueTest {
  /**
   * Test Builder {@link Builder#axisOrientation(AxisOrientation)}.
   * <p>
   * Method under test: {@link Builder#axisOrientation(AxisOrientation)}
   */
  @Test
  @DisplayName("Test Builder axisOrientation(AxisOrientation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.axisOrientation(AxisOrientation)"})
  void testBuilderAxisOrientation() {
    // Arrange
    Builder builderResult = ImmutableScenarioAxisItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.axisOrientation(AxisOrientation.ROW));
  }

  /**
   * Test Builder {@link Builder#domainItem(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#domainItem(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder domainItem(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.domainItem(EntityReference)"})
  void testBuilderDomainItem_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenarioAxisItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.domainItem(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableScenarioAxisItem.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableScenarioAxisItem.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableScenarioAxisItem.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(ScenarioAxisItem)} with {@code ScenarioAxisItem}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link ScenarioAxisItem} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ScenarioAxisItem)}
   */
  @Test
  @DisplayName("Test Builder from(ScenarioAxisItem) with 'ScenarioAxisItem'; given empty; when ScenarioAxisItem id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ScenarioAxisItem)"})
  void testBuilderFromWithScenarioAxisItem_givenEmpty_whenScenarioAxisItemIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableScenarioAxisItem.builder();
    ScenarioAxisItem instance = mock(ScenarioAxisItem.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.position()).thenReturn(1);
    when(instance.scenarioId()).thenReturn(1L);
    when(instance.axisOrientation()).thenReturn(AxisOrientation.ROW);
    when(instance.domainItem()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).axisOrientation();
    verify(instance).domainItem();
    verify(instance).position();
    verify(instance).scenarioId();
    ImmutableScenarioAxisItem buildResult = builderResult.build();
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.scenarioId());
    assertEquals(AxisOrientation.ROW, buildResult.axisOrientation());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ScenarioAxisItem)} with {@code ScenarioAxisItem}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ScenarioAxisItem)}
   */
  @Test
  @DisplayName("Test Builder from(ScenarioAxisItem) with 'ScenarioAxisItem'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ScenarioAxisItem)"})
  void testBuilderFromWithScenarioAxisItem_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableScenarioAxisItem.builder();
    ScenarioAxisItem instance = mock(ScenarioAxisItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.position()).thenReturn(1);
    when(instance.scenarioId()).thenReturn(1L);
    when(instance.axisOrientation()).thenReturn(AxisOrientation.ROW);
    when(instance.domainItem()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).axisOrientation();
    verify(instance).domainItem();
    verify(instance).position();
    verify(instance).scenarioId();
    ImmutableScenarioAxisItem buildResult = builderResult.build();
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.scenarioId());
    assertEquals(AxisOrientation.ROW, buildResult.axisOrientation());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ScenarioAxisItem)} with {@code ScenarioAxisItem}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ScenarioAxisItem)}
   */
  @Test
  @DisplayName("Test Builder from(ScenarioAxisItem) with 'ScenarioAxisItem'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ScenarioAxisItem)"})
  void testBuilderFromWithScenarioAxisItem_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableScenarioAxisItem.builder();
    ScenarioAxisItem instance = mock(ScenarioAxisItem.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.position()).thenReturn(1);
    when(instance.scenarioId()).thenReturn(1L);
    when(instance.axisOrientation()).thenReturn(AxisOrientation.ROW);
    when(instance.domainItem()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).axisOrientation();
    verify(instance).domainItem();
    verify(instance).position();
    verify(instance).scenarioId();
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableScenarioAxisItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableScenarioAxisItem.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   * <p>
   * Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableScenarioAxisItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Test Builder {@link Builder#scenarioId(long)}.
   * <p>
   * Method under test: {@link Builder#scenarioId(long)}
   */
  @Test
  @DisplayName("Test Builder scenarioId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.scenarioId(long)"})
  void testBuilderScenarioId() {
    // Arrange
    Builder builderResult = ImmutableScenarioAxisItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scenarioId(1L));
  }

  /**
   * Test Json {@link Json#axisOrientation()}.
   * <p>
   * Method under test: {@link Json#axisOrientation()}
   */
  @Test
  @DisplayName("Test Json axisOrientation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AxisOrientation Json.axisOrientation()"})
  void testJsonAxisOrientation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).axisOrientation());
  }

  /**
   * Test Json {@link Json#domainItem()}.
   * <p>
   * Method under test: {@link Json#domainItem()}
   */
  @Test
  @DisplayName("Test Json domainItem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.domainItem()"})
  void testJsonDomainItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).domainItem());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
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
    assertNull(actualJson.axisOrientation);
    assertNull(actualJson.domainItem);
    assertEquals(0, actualJson.position);
    assertEquals(0L, actualJson.scenarioId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.positionIsSet);
    assertFalse(actualJson.scenarioIdIsSet);
  }

  /**
   * Test Json {@link Json#position()}.
   * <p>
   * Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).position());
  }

  /**
   * Test Json {@link Json#scenarioId()}.
   * <p>
   * Method under test: {@link Json#scenarioId()}
   */
  @Test
  @DisplayName("Test Json scenarioId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.scenarioId()"})
  void testJsonScenarioId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).scenarioId());
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   * <p>
   * Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setPosition(int)"})
  void testJsonSetPosition() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Test Json {@link Json#setScenarioId(long)}.
   * <p>
   * Method under test: {@link Json#setScenarioId(long)}
   */
  @Test
  @DisplayName("Test Json setScenarioId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setScenarioId(long)"})
  void testJsonSetScenarioId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setScenarioId(1L);

    // Assert
    assertEquals(1L, json.scenarioId);
    assertTrue(json.scenarioIdIsSet);
  }
}
