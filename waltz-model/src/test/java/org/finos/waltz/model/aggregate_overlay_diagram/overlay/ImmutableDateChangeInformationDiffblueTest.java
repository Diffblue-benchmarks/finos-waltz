package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableDateChangeInformation.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableDateChangeInformation.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDateChangeInformationDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllChanges(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllChanges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChanges(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllChanges(Iterable)"})
  void testBuilderAddAllChanges_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChanges(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addChanges(AppChangeEntry)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableAppChangeEntry.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addChanges(AppChangeEntry)}
   */
  @Test
  @DisplayName("Test Builder addChanges(AppChangeEntry) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addChanges(AppChangeEntry)"})
  void testBuilderAddChangesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChanges(new ImmutableAppChangeEntry.Json()));
  }

  /**
   * Test Builder {@link Builder#addChanges(AppChangeEntry[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableAppChangeEntry.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addChanges(AppChangeEntry[])}
   */
  @Test
  @DisplayName("Test Builder addChanges(AppChangeEntry[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addChanges(AppChangeEntry[])"})
  void testBuilderAddChangesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChanges(new ImmutableAppChangeEntry.Json()));
  }

  /**
   * Test Builder {@link Builder#changes(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#changes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder changes(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.changes(Iterable)"})
  void testBuilderChanges_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changes(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(DateChangeInformation)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableAppChangeEntry.Json} (default constructor).</li>
   *   <li>Then return build changes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DateChangeInformation)}
   */
  @Test
  @DisplayName("Test Builder from(DateChangeInformation); given HashSet() add Json (default constructor); then return build changes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DateChangeInformation)"})
  void testBuilderFrom_givenHashSetAddJson_thenReturnBuildChangesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();

    HashSet<AppChangeEntry> appChangeEntrySet = new HashSet<>();
    appChangeEntrySet.add(new ImmutableAppChangeEntry.Json());
    DateChangeInformation instance = mock(DateChangeInformation.class);
    when(instance.changes()).thenReturn(appChangeEntrySet);
    when(instance.quarter()).thenReturn(new ImmutableQuarterDetail.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changes();
    verify(instance).quarter();
    ImmutableDateChangeInformation buildResult = actualFromResult.build();
    assertEquals(1, buildResult.changes().size());
    ImmutableDateChangeInformation buildResult2 = builderResult.build();
    assertEquals(1, buildResult2.changes().size());
    assertEquals(1, buildResult.count());
    assertEquals(1, buildResult2.count());
  }

  /**
   * Test Builder {@link Builder#from(DateChangeInformation)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then builder build count is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DateChangeInformation)}
   */
  @Test
  @DisplayName("Test Builder from(DateChangeInformation); given HashSet(); then builder build count is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DateChangeInformation)"})
  void testBuilderFrom_givenHashSet_thenBuilderBuildCountIsZero() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();
    DateChangeInformation instance = mock(DateChangeInformation.class);
    when(instance.changes()).thenReturn(new HashSet<>());
    ImmutableQuarterDetail.Json json = new ImmutableQuarterDetail.Json();
    when(instance.quarter()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changes();
    verify(instance).quarter();
    ImmutableDateChangeInformation buildResult = builderResult.build();
    assertEquals(0, buildResult.count());
    assertSame(json, buildResult.quarter());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DateChangeInformation)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DateChangeInformation)}
   */
  @Test
  @DisplayName("Test Builder from(DateChangeInformation); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DateChangeInformation)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();
    DateChangeInformation instance = mock(DateChangeInformation.class);
    when(instance.changes()).thenThrow(new IllegalStateException("instance"));
    when(instance.quarter()).thenReturn(new ImmutableQuarterDetail.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).changes();
    verify(instance).quarter();
  }

  /**
   * Test Builder {@link Builder#quarter(QuarterDetail)}.
   * <ul>
   *   <li>When {@link ImmutableQuarterDetail.Json} (default constructor).</li>
   *   <li>Then builder build count is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#quarter(QuarterDetail)}
   */
  @Test
  @DisplayName("Test Builder quarter(QuarterDetail); when Json (default constructor); then builder build count is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.quarter(QuarterDetail)"})
  void testBuilderQuarter_whenJson_thenBuilderBuildCountIsZero() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();
    ImmutableQuarterDetail.Json quarter = new ImmutableQuarterDetail.Json();

    // Act
    Builder actualQuarterResult = builderResult.quarter(quarter);

    // Assert
    ImmutableDateChangeInformation buildResult = builderResult.build();
    assertEquals(0, buildResult.count());
    assertSame(quarter, buildResult.quarter());
    assertSame(builderResult, actualQuarterResult);
  }

  /**
   * Test Json {@link Json#changes()}.
   * <p>
   * Method under test: {@link Json#changes()}
   */
  @Test
  @DisplayName("Test Json changes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.changes()"})
  void testJsonChanges() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).changes());
  }

  /**
   * Test Json {@link Json#count()}.
   * <p>
   * Method under test: {@link Json#count()}
   */
  @Test
  @DisplayName("Test Json count()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.count()"})
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).count());
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
    assertNull(actualJson.quarter);
    assertTrue(actualJson.changes.isEmpty());
  }

  /**
   * Test Json {@link Json#quarter()}.
   * <p>
   * Method under test: {@link Json#quarter()}
   */
  @Test
  @DisplayName("Test Json quarter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"QuarterDetail Json.quarter()"})
  void testJsonQuarter() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).quarter());
  }
}
