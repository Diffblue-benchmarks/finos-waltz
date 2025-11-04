package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionInfo;
import org.finos.waltz.model.measurable_rating_replacement.MeasurableRatingReplacement;
import org.junit.jupiter.api.Test;

class ImmutableDecommissionsViewDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Builder#addAllPlannedDecommissions(Iterable)}
   */
  @Test
  void testBuilderAddAllPlannedDecommissions() {
    // Arrange
    ImmutableDecommissionsView.Builder builderResult = ImmutableDecommissionsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllPlannedDecommissions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Builder#addAllPlannedReplacements(Iterable)}
   */
  @Test
  void testBuilderAddAllPlannedReplacements() {
    // Arrange
    ImmutableDecommissionsView.Builder builderResult = ImmutableDecommissionsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllPlannedReplacements(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Builder#addAllReplacingDecommissions(Iterable)}
   */
  @Test
  void testBuilderAddAllReplacingDecommissions() {
    // Arrange
    ImmutableDecommissionsView.Builder builderResult = ImmutableDecommissionsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllReplacingDecommissions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Builder#addPlannedDecommissions(MeasurableRatingPlannedDecommission)}
   */
  @Test
  void testBuilderAddPlannedDecommissions() {
    // Arrange
    ImmutableDecommissionsView.Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    ImmutableDecommissionsView.Builder actualAddPlannedDecommissionsResult = builderResult
        .addPlannedDecommissions(mock(MeasurableRatingPlannedDecommission.class));

    // Assert
    assertEquals(1, builderResult.build().plannedDecommissions().size());
    assertSame(builderResult, actualAddPlannedDecommissionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Builder#addPlannedDecommissions(MeasurableRatingPlannedDecommission[])}
   */
  @Test
  void testBuilderAddPlannedDecommissions2() {
    // Arrange
    ImmutableDecommissionsView.Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    ImmutableDecommissionsView.Builder actualAddPlannedDecommissionsResult = builderResult
        .addPlannedDecommissions(mock(MeasurableRatingPlannedDecommission.class));

    // Assert
    assertEquals(1, builderResult.build().plannedDecommissions().size());
    assertSame(builderResult, actualAddPlannedDecommissionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Builder#addPlannedReplacements(MeasurableRatingReplacement)}
   */
  @Test
  void testBuilderAddPlannedReplacements() {
    // Arrange
    ImmutableDecommissionsView.Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    ImmutableDecommissionsView.Builder actualAddPlannedReplacementsResult = builderResult
        .addPlannedReplacements(mock(MeasurableRatingReplacement.class));

    // Assert
    assertEquals(1, builderResult.build().plannedReplacements().size());
    assertSame(builderResult, actualAddPlannedReplacementsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Builder#addPlannedReplacements(MeasurableRatingReplacement[])}
   */
  @Test
  void testBuilderAddPlannedReplacements2() {
    // Arrange
    ImmutableDecommissionsView.Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    ImmutableDecommissionsView.Builder actualAddPlannedReplacementsResult = builderResult
        .addPlannedReplacements(mock(MeasurableRatingReplacement.class));

    // Assert
    assertEquals(1, builderResult.build().plannedReplacements().size());
    assertSame(builderResult, actualAddPlannedReplacementsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Builder#addReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo)}
   */
  @Test
  void testBuilderAddReplacingDecommissions() {
    // Arrange
    ImmutableDecommissionsView.Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    ImmutableDecommissionsView.Builder actualAddReplacingDecommissionsResult = builderResult
        .addReplacingDecommissions(mock(MeasurableRatingPlannedDecommissionInfo.class));

    // Assert
    assertEquals(1, builderResult.build().replacingDecommissions().size());
    assertSame(builderResult, actualAddReplacingDecommissionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Builder#addReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo[])}
   */
  @Test
  void testBuilderAddReplacingDecommissions2() {
    // Arrange
    ImmutableDecommissionsView.Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    ImmutableDecommissionsView.Builder actualAddReplacingDecommissionsResult = builderResult
        .addReplacingDecommissions(mock(MeasurableRatingPlannedDecommissionInfo.class));

    // Assert
    assertEquals(1, builderResult.build().replacingDecommissions().size());
    assertSame(builderResult, actualAddReplacingDecommissionsResult);
  }

  /**
   * Method under test: {@link ImmutableDecommissionsView.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableDecommissionsView.builder().build().plannedDecommissions().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Builder#from(DecommissionsView)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDecommissionsView.Builder builderResult = ImmutableDecommissionsView.builder();
    DecommissionsView instance = mock(DecommissionsView.class);
    when(instance.plannedDecommissions()).thenReturn(new HashSet<>());
    when(instance.plannedReplacements()).thenReturn(new HashSet<>());
    when(instance.replacingDecommissions()).thenReturn(new HashSet<>());

    // Act
    ImmutableDecommissionsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).plannedDecommissions();
    verify(instance).plannedReplacements();
    verify(instance).replacingDecommissions();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Builder#from(DecommissionsView)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDecommissionsView.Builder builderResult = ImmutableDecommissionsView.builder();

    HashSet<MeasurableRatingPlannedDecommission> measurableRatingPlannedDecommissionSet = new HashSet<>();
    measurableRatingPlannedDecommissionSet.add(mock(MeasurableRatingPlannedDecommission.class));
    DecommissionsView instance = mock(DecommissionsView.class);
    when(instance.plannedDecommissions()).thenReturn(measurableRatingPlannedDecommissionSet);
    when(instance.plannedReplacements()).thenReturn(new HashSet<>());
    when(instance.replacingDecommissions()).thenReturn(new HashSet<>());

    // Act
    ImmutableDecommissionsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).plannedDecommissions();
    verify(instance).plannedReplacements();
    verify(instance).replacingDecommissions();
    assertEquals(1, builderResult.build().plannedDecommissions().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Builder#from(DecommissionsView)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableDecommissionsView.Builder builderResult = ImmutableDecommissionsView.builder();

    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    measurableRatingReplacementSet.add(mock(MeasurableRatingReplacement.class));
    DecommissionsView instance = mock(DecommissionsView.class);
    when(instance.plannedDecommissions()).thenReturn(new HashSet<>());
    when(instance.plannedReplacements()).thenReturn(measurableRatingReplacementSet);
    when(instance.replacingDecommissions()).thenReturn(new HashSet<>());

    // Act
    ImmutableDecommissionsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).plannedDecommissions();
    verify(instance).plannedReplacements();
    verify(instance).replacingDecommissions();
    assertEquals(1, builderResult.build().plannedReplacements().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Builder#from(DecommissionsView)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableDecommissionsView.Builder builderResult = ImmutableDecommissionsView.builder();

    HashSet<MeasurableRatingPlannedDecommissionInfo> measurableRatingPlannedDecommissionInfoSet = new HashSet<>();
    measurableRatingPlannedDecommissionInfoSet.add(mock(MeasurableRatingPlannedDecommissionInfo.class));
    DecommissionsView instance = mock(DecommissionsView.class);
    when(instance.plannedDecommissions()).thenReturn(new HashSet<>());
    when(instance.plannedReplacements()).thenReturn(new HashSet<>());
    when(instance.replacingDecommissions()).thenReturn(measurableRatingPlannedDecommissionInfoSet);

    // Act
    ImmutableDecommissionsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).plannedDecommissions();
    verify(instance).plannedReplacements();
    verify(instance).replacingDecommissions();
    assertEquals(1, builderResult.build().replacingDecommissions().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Builder#plannedDecommissions(Iterable)}
   */
  @Test
  void testBuilderPlannedDecommissions() {
    // Arrange
    ImmutableDecommissionsView.Builder builderResult = ImmutableDecommissionsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.plannedDecommissions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Builder#plannedReplacements(Iterable)}
   */
  @Test
  void testBuilderPlannedReplacements() {
    // Arrange
    ImmutableDecommissionsView.Builder builderResult = ImmutableDecommissionsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.plannedReplacements(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Builder#replacingDecommissions(Iterable)}
   */
  @Test
  void testBuilderReplacingDecommissions() {
    // Arrange
    ImmutableDecommissionsView.Builder builderResult = ImmutableDecommissionsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.replacingDecommissions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView#copyOf(DecommissionsView)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    DecommissionsView instance = mock(DecommissionsView.class);
    when(instance.plannedDecommissions()).thenReturn(new HashSet<>());
    when(instance.plannedReplacements()).thenReturn(new HashSet<>());
    when(instance.replacingDecommissions()).thenReturn(new HashSet<>());

    // Act
    ImmutableDecommissionsView actualCopyOfResult = ImmutableDecommissionsView.copyOf(instance);

    // Assert
    verify(instance).plannedDecommissions();
    verify(instance).plannedReplacements();
    verify(instance).replacingDecommissions();
    Set<MeasurableRatingPlannedDecommission> plannedDecommissionsResult = actualCopyOfResult.plannedDecommissions();
    assertTrue(plannedDecommissionsResult.isEmpty());
    assertSame(plannedDecommissionsResult, actualCopyOfResult.plannedReplacements());
    assertSame(plannedDecommissionsResult, actualCopyOfResult.replacingDecommissions());
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView#copyOf(DecommissionsView)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<MeasurableRatingPlannedDecommission> measurableRatingPlannedDecommissionSet = new HashSet<>();
    measurableRatingPlannedDecommissionSet.add(mock(MeasurableRatingPlannedDecommission.class));
    DecommissionsView instance = mock(DecommissionsView.class);
    when(instance.plannedDecommissions()).thenReturn(measurableRatingPlannedDecommissionSet);
    when(instance.plannedReplacements()).thenReturn(new HashSet<>());
    when(instance.replacingDecommissions()).thenReturn(new HashSet<>());

    // Act
    ImmutableDecommissionsView actualCopyOfResult = ImmutableDecommissionsView.copyOf(instance);

    // Assert
    verify(instance).plannedDecommissions();
    verify(instance).plannedReplacements();
    verify(instance).replacingDecommissions();
    assertEquals(1, actualCopyOfResult.plannedDecommissions().size());
    Set<MeasurableRatingReplacement> plannedReplacementsResult = actualCopyOfResult.plannedReplacements();
    assertTrue(plannedReplacementsResult.isEmpty());
    assertSame(plannedReplacementsResult, actualCopyOfResult.replacingDecommissions());
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView#copyOf(DecommissionsView)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<MeasurableRatingPlannedDecommission> measurableRatingPlannedDecommissionSet = new HashSet<>();
    measurableRatingPlannedDecommissionSet.add(mock(MeasurableRatingPlannedDecommission.class));
    measurableRatingPlannedDecommissionSet.add(mock(MeasurableRatingPlannedDecommission.class));
    DecommissionsView instance = mock(DecommissionsView.class);
    when(instance.plannedDecommissions()).thenReturn(measurableRatingPlannedDecommissionSet);
    when(instance.plannedReplacements()).thenReturn(new HashSet<>());
    when(instance.replacingDecommissions()).thenReturn(new HashSet<>());

    // Act
    ImmutableDecommissionsView actualCopyOfResult = ImmutableDecommissionsView.copyOf(instance);

    // Assert
    verify(instance).plannedDecommissions();
    verify(instance).plannedReplacements();
    verify(instance).replacingDecommissions();
    Set<MeasurableRatingReplacement> plannedReplacementsResult = actualCopyOfResult.plannedReplacements();
    assertTrue(plannedReplacementsResult.isEmpty());
    assertEquals(measurableRatingPlannedDecommissionSet, actualCopyOfResult.plannedDecommissions());
    assertSame(plannedReplacementsResult, actualCopyOfResult.replacingDecommissions());
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView#copyOf(DecommissionsView)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    measurableRatingReplacementSet.add(mock(MeasurableRatingReplacement.class));
    DecommissionsView instance = mock(DecommissionsView.class);
    when(instance.plannedDecommissions()).thenReturn(new HashSet<>());
    when(instance.plannedReplacements()).thenReturn(measurableRatingReplacementSet);
    when(instance.replacingDecommissions()).thenReturn(new HashSet<>());

    // Act
    ImmutableDecommissionsView actualCopyOfResult = ImmutableDecommissionsView.copyOf(instance);

    // Assert
    verify(instance).plannedDecommissions();
    verify(instance).plannedReplacements();
    verify(instance).replacingDecommissions();
    assertEquals(1, actualCopyOfResult.plannedReplacements().size());
    Set<MeasurableRatingPlannedDecommission> plannedDecommissionsResult = actualCopyOfResult.plannedDecommissions();
    assertTrue(plannedDecommissionsResult.isEmpty());
    assertSame(plannedDecommissionsResult, actualCopyOfResult.replacingDecommissions());
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView#copyOf(DecommissionsView)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    HashSet<MeasurableRatingPlannedDecommissionInfo> measurableRatingPlannedDecommissionInfoSet = new HashSet<>();
    measurableRatingPlannedDecommissionInfoSet.add(mock(MeasurableRatingPlannedDecommissionInfo.class));
    DecommissionsView instance = mock(DecommissionsView.class);
    when(instance.plannedDecommissions()).thenReturn(new HashSet<>());
    when(instance.plannedReplacements()).thenReturn(new HashSet<>());
    when(instance.replacingDecommissions()).thenReturn(measurableRatingPlannedDecommissionInfoSet);

    // Act
    ImmutableDecommissionsView actualCopyOfResult = ImmutableDecommissionsView.copyOf(instance);

    // Assert
    verify(instance).plannedDecommissions();
    verify(instance).plannedReplacements();
    verify(instance).replacingDecommissions();
    assertEquals(1, actualCopyOfResult.replacingDecommissions().size());
    Set<MeasurableRatingPlannedDecommission> plannedDecommissionsResult = actualCopyOfResult.plannedDecommissions();
    assertTrue(plannedDecommissionsResult.isEmpty());
    assertSame(plannedDecommissionsResult, actualCopyOfResult.plannedReplacements());
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView#fromJson(ImmutableDecommissionsView.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableDecommissionsView.Json json = new ImmutableDecommissionsView.Json();

    // Act
    ImmutableDecommissionsView actualFromJsonResult = ImmutableDecommissionsView.fromJson(json);

    // Assert
    Set<MeasurableRatingPlannedDecommission> plannedDecommissionsResult = actualFromJsonResult.plannedDecommissions();
    assertTrue(plannedDecommissionsResult.isEmpty());
    Set<MeasurableRatingPlannedDecommissionInfo> measurableRatingPlannedDecommissionInfoSet = json.replacingDecommissions;
    assertSame(measurableRatingPlannedDecommissionInfoSet, plannedDecommissionsResult);
    assertSame(measurableRatingPlannedDecommissionInfoSet, actualFromJsonResult.plannedReplacements());
    assertSame(measurableRatingPlannedDecommissionInfoSet, actualFromJsonResult.replacingDecommissions());
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView#fromJson(ImmutableDecommissionsView.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableDecommissionsView.Json json = new ImmutableDecommissionsView.Json();
    json.setPlannedDecommissions(null);
    json.setReplacingDecommissions(null);
    json.setPlannedReplacements(null);

    // Act
    ImmutableDecommissionsView actualFromJsonResult = ImmutableDecommissionsView.fromJson(json);

    // Assert
    Set<MeasurableRatingPlannedDecommission> plannedDecommissionsResult = actualFromJsonResult.plannedDecommissions();
    assertTrue(plannedDecommissionsResult.isEmpty());
    assertSame(plannedDecommissionsResult, actualFromJsonResult.plannedReplacements());
    assertSame(plannedDecommissionsResult, actualFromJsonResult.replacingDecommissions());
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView#fromJson(ImmutableDecommissionsView.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<MeasurableRatingReplacement> plannedReplacements = new LinkedHashSet<>();
    plannedReplacements.add(mock(MeasurableRatingReplacement.class));

    ImmutableDecommissionsView.Json json = new ImmutableDecommissionsView.Json();
    json.setPlannedDecommissions(null);
    json.setReplacingDecommissions(null);
    json.setPlannedReplacements(plannedReplacements);

    // Act
    ImmutableDecommissionsView actualFromJsonResult = ImmutableDecommissionsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.plannedReplacements().size());
    Set<MeasurableRatingPlannedDecommission> plannedDecommissionsResult = actualFromJsonResult.plannedDecommissions();
    assertTrue(plannedDecommissionsResult.isEmpty());
    assertSame(plannedDecommissionsResult, actualFromJsonResult.replacingDecommissions());
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView#fromJson(ImmutableDecommissionsView.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<MeasurableRatingPlannedDecommissionInfo> replacingDecommissions = new LinkedHashSet<>();
    replacingDecommissions.add(mock(MeasurableRatingPlannedDecommissionInfo.class));

    ImmutableDecommissionsView.Json json = new ImmutableDecommissionsView.Json();
    json.setPlannedDecommissions(null);
    json.setReplacingDecommissions(replacingDecommissions);
    json.setPlannedReplacements(null);

    // Act
    ImmutableDecommissionsView actualFromJsonResult = ImmutableDecommissionsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.replacingDecommissions().size());
    Set<MeasurableRatingPlannedDecommission> plannedDecommissionsResult = actualFromJsonResult.plannedDecommissions();
    assertTrue(plannedDecommissionsResult.isEmpty());
    assertSame(plannedDecommissionsResult, actualFromJsonResult.plannedReplacements());
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView#fromJson(ImmutableDecommissionsView.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    LinkedHashSet<MeasurableRatingPlannedDecommission> plannedDecommissions = new LinkedHashSet<>();
    plannedDecommissions.add(mock(MeasurableRatingPlannedDecommission.class));

    ImmutableDecommissionsView.Json json = new ImmutableDecommissionsView.Json();
    json.setPlannedDecommissions(plannedDecommissions);
    json.setReplacingDecommissions(null);
    json.setPlannedReplacements(null);

    // Act
    ImmutableDecommissionsView actualFromJsonResult = ImmutableDecommissionsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.plannedDecommissions().size());
    Set<MeasurableRatingReplacement> plannedReplacementsResult = actualFromJsonResult.plannedReplacements();
    assertTrue(plannedReplacementsResult.isEmpty());
    assertSame(plannedReplacementsResult, actualFromJsonResult.replacingDecommissions());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableDecommissionsView.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableDecommissionsView.Json actualJson = new ImmutableDecommissionsView.Json();

    // Assert
    assertTrue(actualJson.plannedDecommissions.isEmpty());
    assertTrue(actualJson.plannedReplacements.isEmpty());
    assertTrue(actualJson.replacingDecommissions.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Json#plannedDecommissions()}
   */
  @Test
  void testJsonPlannedDecommissions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDecommissionsView.Json()).plannedDecommissions());
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Json#plannedReplacements()}
   */
  @Test
  void testJsonPlannedReplacements() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDecommissionsView.Json()).plannedReplacements());
  }

  /**
   * Method under test:
   * {@link ImmutableDecommissionsView.Json#replacingDecommissions()}
   */
  @Test
  void testJsonReplacingDecommissions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDecommissionsView.Json()).replacingDecommissions());
  }
}
