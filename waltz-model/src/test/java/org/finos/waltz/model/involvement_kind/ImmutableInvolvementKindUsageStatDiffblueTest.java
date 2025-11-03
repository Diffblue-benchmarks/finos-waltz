package org.finos.waltz.model.involvement_kind;

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
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKindUsageStat.Builder;
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKindUsageStat.Json;
import org.finos.waltz.model.involvement_kind.InvolvementKindUsageStat.Stat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementKindUsageStatDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllBreakdown(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllBreakdown(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllBreakdown(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllBreakdown(Iterable)"})
  void testBuilderAddAllBreakdown_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllBreakdown(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addBreakdown(Stat)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableStat.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addBreakdown(Stat)}
   */
  @Test
  @DisplayName("Test Builder addBreakdown(Stat) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addBreakdown(Stat)"})
  void testBuilderAddBreakdownWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addBreakdown(new ImmutableStat.Json()));
  }

  /**
   * Test Builder {@link Builder#addBreakdown(Stat[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableStat.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addBreakdown(Stat[])}
   */
  @Test
  @DisplayName("Test Builder addBreakdown(Stat[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addBreakdown(Stat[])"})
  void testBuilderAddBreakdownWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addBreakdown(new ImmutableStat.Json()));
  }

  /**
   * Test Builder {@link Builder#breakdown(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#breakdown(Iterable)}
   */
  @Test
  @DisplayName("Test Builder breakdown(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.breakdown(Iterable)"})
  void testBuilderBreakdown_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.breakdown(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(InvolvementKindUsageStat)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableStat.Json} (default constructor).</li>
   *   <li>Then return build breakdown size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(InvolvementKindUsageStat)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementKindUsageStat); given HashSet() add Json (default constructor); then return build breakdown size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InvolvementKindUsageStat)"})
  void testBuilderFrom_givenHashSetAddJson_thenReturnBuildBreakdownSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    HashSet<Stat> statSet = new HashSet<>();
    statSet.add(new ImmutableStat.Json());
    InvolvementKindUsageStat instance = mock(InvolvementKindUsageStat.class);
    when(instance.breakdown()).thenReturn(statSet);
    when(instance.involvementKind()).thenReturn(new ImmutableInvolvementKind.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).breakdown();
    verify(instance).involvementKind();
    assertEquals(1, actualFromResult.build().breakdown().size());
    assertEquals(1, builderResult.build().breakdown().size());
  }

  /**
   * Test Builder {@link Builder#from(InvolvementKindUsageStat)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then builder build involvementKind is {@link ImmutableInvolvementKind.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(InvolvementKindUsageStat)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementKindUsageStat); given HashSet(); then builder build involvementKind is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InvolvementKindUsageStat)"})
  void testBuilderFrom_givenHashSet_thenBuilderBuildInvolvementKindIsJson() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();
    InvolvementKindUsageStat instance = mock(InvolvementKindUsageStat.class);
    when(instance.breakdown()).thenReturn(new HashSet<>());
    ImmutableInvolvementKind.Json json = new ImmutableInvolvementKind.Json();
    when(instance.involvementKind()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).breakdown();
    verify(instance).involvementKind();
    assertSame(json, builderResult.build().involvementKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#involvementKind(InvolvementKind)}.
   * <ul>
   *   <li>When {@link ImmutableInvolvementKind.Json} (default constructor).</li>
   *   <li>Then builder build involvementKind is {@link ImmutableInvolvementKind.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#involvementKind(InvolvementKind)}
   */
  @Test
  @DisplayName("Test Builder involvementKind(InvolvementKind); when Json (default constructor); then builder build involvementKind is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.involvementKind(InvolvementKind)"})
  void testBuilderInvolvementKind_whenJson_thenBuilderBuildInvolvementKindIsJson() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();
    ImmutableInvolvementKind.Json involvementKind = new ImmutableInvolvementKind.Json();

    // Act
    Builder actualInvolvementKindResult = builderResult.involvementKind(involvementKind);

    // Assert
    assertSame(involvementKind, builderResult.build().involvementKind());
    assertSame(builderResult, actualInvolvementKindResult);
  }

  /**
   * Test Json {@link Json#breakdown()}.
   * <p>
   * Method under test: {@link Json#breakdown()}
   */
  @Test
  @DisplayName("Test Json breakdown()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.breakdown()"})
  void testJsonBreakdown() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).breakdown());
  }

  /**
   * Test Json {@link Json#involvementKind()}.
   * <p>
   * Method under test: {@link Json#involvementKind()}
   */
  @Test
  @DisplayName("Test Json involvementKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InvolvementKind Json.involvementKind()"})
  void testJsonInvolvementKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).involvementKind());
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
    assertNull(actualJson.involvementKind);
    assertTrue(actualJson.breakdown.isEmpty());
  }
}
