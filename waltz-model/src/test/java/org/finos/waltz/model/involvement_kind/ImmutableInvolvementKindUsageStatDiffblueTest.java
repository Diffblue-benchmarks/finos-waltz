package org.finos.waltz.model.involvement_kind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementKindUsageStatDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableInvolvementKindUsageStat.Builder#addAllBreakdown(Iterable)}
   */
  @Test
  void testBuilderAddAllBreakdown() {
    // Arrange
    ImmutableInvolvementKindUsageStat.Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllBreakdown(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindUsageStat.Builder#addBreakdown(InvolvementKindUsageStat.Stat)}
   */
  @Test
  void testBuilderAddBreakdown() {
    // Arrange
    ImmutableInvolvementKindUsageStat.Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addBreakdown(new ImmutableStat.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindUsageStat.Builder#addBreakdown(InvolvementKindUsageStat.Stat[])}
   */
  @Test
  void testBuilderAddBreakdown2() {
    // Arrange
    ImmutableInvolvementKindUsageStat.Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addBreakdown(new ImmutableStat.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindUsageStat.Builder#breakdown(Iterable)}
   */
  @Test
  void testBuilderBreakdown() {
    // Arrange
    ImmutableInvolvementKindUsageStat.Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.breakdown(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindUsageStat.Builder#from(InvolvementKindUsageStat)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableInvolvementKindUsageStat.Builder builderResult = ImmutableInvolvementKindUsageStat.builder();
    InvolvementKindUsageStat instance = mock(InvolvementKindUsageStat.class);
    when(instance.breakdown()).thenReturn(new HashSet<>());
    ImmutableInvolvementKind.Json json = new ImmutableInvolvementKind.Json();
    when(instance.involvementKind()).thenReturn(json);

    // Act
    ImmutableInvolvementKindUsageStat.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).breakdown();
    verify(instance).involvementKind();
    assertSame(json, builderResult.build().involvementKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindUsageStat.Builder#from(InvolvementKindUsageStat)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableInvolvementKindUsageStat.Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    HashSet<InvolvementKindUsageStat.Stat> statSet = new HashSet<>();
    statSet.add(new ImmutableStat.Json());
    InvolvementKindUsageStat instance = mock(InvolvementKindUsageStat.class);
    when(instance.breakdown()).thenReturn(statSet);
    ImmutableInvolvementKind.Json json = new ImmutableInvolvementKind.Json();
    when(instance.involvementKind()).thenReturn(json);

    // Act
    ImmutableInvolvementKindUsageStat.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).breakdown();
    verify(instance).involvementKind();
    ImmutableInvolvementKindUsageStat buildResult = builderResult.build();
    assertEquals(1, buildResult.breakdown().size());
    assertSame(json, buildResult.involvementKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindUsageStat.Builder#involvementKind(InvolvementKind)}
   */
  @Test
  void testBuilderInvolvementKind() {
    // Arrange
    ImmutableInvolvementKindUsageStat.Builder builderResult = ImmutableInvolvementKindUsageStat.builder();
    ImmutableInvolvementKind.Json involvementKind = new ImmutableInvolvementKind.Json();

    // Act
    ImmutableInvolvementKindUsageStat.Builder actualInvolvementKindResult = builderResult
        .involvementKind(involvementKind);

    // Assert
    assertSame(involvementKind, builderResult.build().involvementKind());
    assertSame(builderResult, actualInvolvementKindResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindUsageStat#copyOf(InvolvementKindUsageStat)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    InvolvementKindUsageStat instance = mock(InvolvementKindUsageStat.class);
    when(instance.breakdown()).thenReturn(new HashSet<>());
    ImmutableInvolvementKind.Json json = new ImmutableInvolvementKind.Json();
    when(instance.involvementKind()).thenReturn(json);

    // Act
    ImmutableInvolvementKindUsageStat actualCopyOfResult = ImmutableInvolvementKindUsageStat.copyOf(instance);

    // Assert
    verify(instance).breakdown();
    verify(instance).involvementKind();
    assertTrue(actualCopyOfResult.breakdown().isEmpty());
    assertSame(json, actualCopyOfResult.involvementKind());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindUsageStat#copyOf(InvolvementKindUsageStat)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<InvolvementKindUsageStat.Stat> statSet = new HashSet<>();
    statSet.add(new ImmutableStat.Json());
    InvolvementKindUsageStat instance = mock(InvolvementKindUsageStat.class);
    when(instance.breakdown()).thenReturn(statSet);
    ImmutableInvolvementKind.Json json = new ImmutableInvolvementKind.Json();
    when(instance.involvementKind()).thenReturn(json);

    // Act
    ImmutableInvolvementKindUsageStat actualCopyOfResult = ImmutableInvolvementKindUsageStat.copyOf(instance);

    // Assert
    verify(instance).breakdown();
    verify(instance).involvementKind();
    assertEquals(1, actualCopyOfResult.breakdown().size());
    assertSame(json, actualCopyOfResult.involvementKind());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindUsageStat#copyOf(InvolvementKindUsageStat)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<InvolvementKindUsageStat.Stat> statSet = new HashSet<>();
    statSet.add(new ImmutableStat.Json());
    statSet.add(new ImmutableStat.Json());
    InvolvementKindUsageStat instance = mock(InvolvementKindUsageStat.class);
    when(instance.breakdown()).thenReturn(statSet);
    ImmutableInvolvementKind.Json json = new ImmutableInvolvementKind.Json();
    when(instance.involvementKind()).thenReturn(json);

    // Act
    ImmutableInvolvementKindUsageStat actualCopyOfResult = ImmutableInvolvementKindUsageStat.copyOf(instance);

    // Assert
    verify(instance).breakdown();
    verify(instance).involvementKind();
    assertEquals(statSet, actualCopyOfResult.breakdown());
    assertSame(json, actualCopyOfResult.involvementKind());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindUsageStat#fromJson(ImmutableInvolvementKindUsageStat.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableInvolvementKindUsageStat.Json json = new ImmutableInvolvementKindUsageStat.Json();
    json.setBreakdown(null);
    ImmutableInvolvementKind.Json involvementKind = new ImmutableInvolvementKind.Json();
    json.setInvolvementKind(involvementKind);

    // Act
    ImmutableInvolvementKindUsageStat actualFromJsonResult = ImmutableInvolvementKindUsageStat.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.breakdown().isEmpty());
    assertSame(involvementKind, actualFromJsonResult.involvementKind());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindUsageStat#fromJson(ImmutableInvolvementKindUsageStat.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<InvolvementKindUsageStat.Stat> breakdown = new LinkedHashSet<>();
    breakdown.add(new ImmutableStat.Json());

    ImmutableInvolvementKindUsageStat.Json json = new ImmutableInvolvementKindUsageStat.Json();
    json.setBreakdown(breakdown);
    ImmutableInvolvementKind.Json involvementKind = new ImmutableInvolvementKind.Json();
    json.setInvolvementKind(involvementKind);

    // Act
    ImmutableInvolvementKindUsageStat actualFromJsonResult = ImmutableInvolvementKindUsageStat.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.breakdown().size());
    assertSame(involvementKind, actualFromJsonResult.involvementKind());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindUsageStat#fromJson(ImmutableInvolvementKindUsageStat.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<InvolvementKindUsageStat.Stat> breakdown = new LinkedHashSet<>();
    breakdown.add(new ImmutableStat.Json());
    breakdown.add(new ImmutableStat.Json());

    ImmutableInvolvementKindUsageStat.Json json = new ImmutableInvolvementKindUsageStat.Json();
    json.setBreakdown(breakdown);
    ImmutableInvolvementKind.Json involvementKind = new ImmutableInvolvementKind.Json();
    json.setInvolvementKind(involvementKind);

    // Act
    ImmutableInvolvementKindUsageStat actualFromJsonResult = ImmutableInvolvementKindUsageStat.fromJson(json);

    // Assert
    assertEquals(breakdown, actualFromJsonResult.breakdown());
    assertSame(involvementKind, actualFromJsonResult.involvementKind());
  }

  /**
   * Method under test: {@link ImmutableInvolvementKindUsageStat.Json#breakdown()}
   */
  @Test
  void testJsonBreakdown() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementKindUsageStat.Json()).breakdown());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindUsageStat.Json#involvementKind()}
   */
  @Test
  void testJsonInvolvementKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInvolvementKindUsageStat.Json()).involvementKind());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableInvolvementKindUsageStat.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableInvolvementKindUsageStat.Json actualJson = new ImmutableInvolvementKindUsageStat.Json();

    // Assert
    assertNull(actualJson.involvementKind);
    assertTrue(actualJson.breakdown.isEmpty());
  }
}
