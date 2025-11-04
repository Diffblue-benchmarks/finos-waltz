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
import java.util.Optional;
import org.finos.waltz.model.AxisOrientation;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.junit.jupiter.api.Test;

class ImmutableScenarioAxisItemDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableScenarioAxisItem.Builder#axisOrientation(AxisOrientation)}
   */
  @Test
  void testBuilderAxisOrientation() {
    // Arrange
    ImmutableScenarioAxisItem.Builder builderResult = ImmutableScenarioAxisItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.axisOrientation(AxisOrientation.ROW));
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioAxisItem.Builder#domainItem(EntityReference)}
   */
  @Test
  void testBuilderDomainItem() {
    // Arrange
    ImmutableScenarioAxisItem.Builder builderResult = ImmutableScenarioAxisItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.domainItem(mock(EntityReference.class)));
  }

  /**
   * Method under test: {@link ImmutableScenarioAxisItem.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableScenarioAxisItem.Builder builderResult = ImmutableScenarioAxisItem.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableScenarioAxisItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableScenarioAxisItem.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableScenarioAxisItem.Builder builderResult = ImmutableScenarioAxisItem.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableScenarioAxisItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableScenarioAxisItem.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableScenarioAxisItem.Builder builderResult = ImmutableScenarioAxisItem.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioAxisItem.Builder#from(ScenarioAxisItem)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableScenarioAxisItem.Builder builderResult = ImmutableScenarioAxisItem.builder();
    ScenarioAxisItem instance = mock(ScenarioAxisItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.position()).thenReturn(1);
    when(instance.scenarioId()).thenReturn(1L);
    when(instance.axisOrientation()).thenReturn(AxisOrientation.ROW);
    when(instance.domainItem()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableScenarioAxisItem.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableScenarioAxisItem.Builder#from(ScenarioAxisItem)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableScenarioAxisItem.Builder builderResult = ImmutableScenarioAxisItem.builder();
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
   * Method under test:
   * {@link ImmutableScenarioAxisItem.Builder#from(ScenarioAxisItem)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableScenarioAxisItem.Builder builderResult = ImmutableScenarioAxisItem.builder();
    ScenarioAxisItem instance = mock(ScenarioAxisItem.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.position()).thenReturn(1);
    when(instance.scenarioId()).thenReturn(1L);
    when(instance.axisOrientation()).thenReturn(AxisOrientation.ROW);
    when(instance.domainItem()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableScenarioAxisItem.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableScenarioAxisItem.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableScenarioAxisItem.Builder builderResult = ImmutableScenarioAxisItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableScenarioAxisItem.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableScenarioAxisItem.Builder builderResult = ImmutableScenarioAxisItem.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableScenarioAxisItem.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutableScenarioAxisItem.Builder builderResult = ImmutableScenarioAxisItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test: {@link ImmutableScenarioAxisItem.Builder#scenarioId(long)}
   */
  @Test
  void testBuilderScenarioId() {
    // Arrange
    ImmutableScenarioAxisItem.Builder builderResult = ImmutableScenarioAxisItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scenarioId(1L));
  }

  /**
   * Method under test: {@link ImmutableScenarioAxisItem#copyOf(ScenarioAxisItem)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ScenarioAxisItem instance = mock(ScenarioAxisItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.position()).thenReturn(1);
    when(instance.scenarioId()).thenReturn(1L);
    when(instance.axisOrientation()).thenReturn(AxisOrientation.ROW);
    when(instance.domainItem()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableScenarioAxisItem actualCopyOfResult = ImmutableScenarioAxisItem.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).axisOrientation();
    verify(instance).domainItem();
    verify(instance).position();
    verify(instance).scenarioId();
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.scenarioId());
    assertEquals(AxisOrientation.ROW, actualCopyOfResult.axisOrientation());
  }

  /**
   * Method under test: {@link ImmutableScenarioAxisItem#copyOf(ScenarioAxisItem)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ScenarioAxisItem instance = mock(ScenarioAxisItem.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.position()).thenReturn(1);
    when(instance.scenarioId()).thenReturn(1L);
    when(instance.axisOrientation()).thenReturn(AxisOrientation.ROW);
    when(instance.domainItem()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableScenarioAxisItem actualCopyOfResult = ImmutableScenarioAxisItem.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).axisOrientation();
    verify(instance).domainItem();
    verify(instance).position();
    verify(instance).scenarioId();
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.scenarioId());
    assertEquals(AxisOrientation.ROW, actualCopyOfResult.axisOrientation());
  }

  /**
   * Method under test: {@link ImmutableScenarioAxisItem.Json#axisOrientation()}
   */
  @Test
  void testJsonAxisOrientation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenarioAxisItem.Json()).axisOrientation());
  }

  /**
   * Method under test: {@link ImmutableScenarioAxisItem.Json#domainItem()}
   */
  @Test
  void testJsonDomainItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenarioAxisItem.Json()).domainItem());
  }

  /**
   * Method under test: {@link ImmutableScenarioAxisItem.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenarioAxisItem.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableScenarioAxisItem.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableScenarioAxisItem.Json actualJson = new ImmutableScenarioAxisItem.Json();

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
   * Method under test: {@link ImmutableScenarioAxisItem.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenarioAxisItem.Json()).position());
  }

  /**
   * Method under test: {@link ImmutableScenarioAxisItem.Json#scenarioId()}
   */
  @Test
  void testJsonScenarioId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenarioAxisItem.Json()).scenarioId());
  }

  /**
   * Method under test: {@link ImmutableScenarioAxisItem.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutableScenarioAxisItem.Json json = new ImmutableScenarioAxisItem.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Method under test: {@link ImmutableScenarioAxisItem.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition2() {
    // Arrange
    ImmutableScenarioAxisItem.Json json = new ImmutableScenarioAxisItem.Json();
    json.setDomainItem(mock(EntityReference.class));

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Method under test: {@link ImmutableScenarioAxisItem.Json#setScenarioId(long)}
   */
  @Test
  void testJsonSetScenarioId() {
    // Arrange
    ImmutableScenarioAxisItem.Json json = new ImmutableScenarioAxisItem.Json();

    // Act
    json.setScenarioId(1L);

    // Assert
    assertEquals(1L, json.scenarioId);
    assertTrue(json.scenarioIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableScenarioAxisItem.Json#setScenarioId(long)}
   */
  @Test
  void testJsonSetScenarioId2() {
    // Arrange
    ImmutableScenarioAxisItem.Json json = new ImmutableScenarioAxisItem.Json();
    json.setDomainItem(mock(EntityReference.class));

    // Act
    json.setScenarioId(1L);

    // Assert
    assertEquals(1L, json.scenarioId);
    assertTrue(json.scenarioIdIsSet);
  }
}
