package org.finos.waltz.model.usage_info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.system.ImmutableSystemChangeSet;
import org.finos.waltz.model.system.SystemChangeSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UsageInfoUtilitiesDiffblueTest {
  /**
   * Test {@link UsageInfoUtilities#mkChangeSet(Set, Set)}.
   *
   * <p>Method under test: {@link UsageInfoUtilities#mkChangeSet(Set, Set)}
   */
  @Test
  @DisplayName("Test mkChangeSet(Set, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemChangeSet UsageInfoUtilities.mkChangeSet(Set, Set)"})
  void testMkChangeSet() {
    // Arrange
    HashSet<UsageInfo> base = new HashSet<>();
    base.add(
        ImmutableUsageInfo.builder()
            .description("Description")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());
    base.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualMkChangeSetResult =
        UsageInfoUtilities.mkChangeSet(base, new HashSet<>());

    // Assert
    assertTrue(actualMkChangeSetResult instanceof ImmutableSystemChangeSet);
    List<UsageKind> deletesResult = actualMkChangeSetResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualMkChangeSetResult.inserts());
    assertSame(deletesResult, actualMkChangeSetResult.updates());
  }

  /**
   * Test {@link UsageInfoUtilities#mkChangeSet(Set, Set)}.
   *
   * <p>Method under test: {@link UsageInfoUtilities#mkChangeSet(Set, Set)}
   */
  @Test
  @DisplayName("Test mkChangeSet(Set, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemChangeSet UsageInfoUtilities.mkChangeSet(Set, Set)"})
  void testMkChangeSet2() {
    // Arrange
    HashSet<UsageInfo> base = new HashSet<>();
    base.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.ORIGINATOR)
            .build());
    base.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    HashSet<UsageInfo> replacements = new HashSet<>();
    replacements.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualMkChangeSetResult =
        UsageInfoUtilities.mkChangeSet(base, replacements);

    // Assert
    assertTrue(actualMkChangeSetResult instanceof ImmutableSystemChangeSet);
    List<UsageKind> deletesResult = actualMkChangeSetResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualMkChangeSetResult.inserts());
    assertSame(deletesResult, actualMkChangeSetResult.updates());
  }

  /**
   * Test {@link UsageInfoUtilities#mkChangeSet(Set, Set)}.
   *
   * <p>Method under test: {@link UsageInfoUtilities#mkChangeSet(Set, Set)}
   */
  @Test
  @DisplayName("Test mkChangeSet(Set, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemChangeSet UsageInfoUtilities.mkChangeSet(Set, Set)"})
  void testMkChangeSet3() {
    // Arrange
    HashSet<UsageInfo> base = new HashSet<>();
    base.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.ORIGINATOR)
            .build());
    base.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    HashSet<UsageInfo> replacements = new HashSet<>();
    replacements.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.ORIGINATOR)
            .build());
    replacements.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualMkChangeSetResult =
        UsageInfoUtilities.mkChangeSet(base, replacements);

    // Assert
    assertTrue(actualMkChangeSetResult instanceof ImmutableSystemChangeSet);
    List<UsageKind> deletesResult = actualMkChangeSetResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualMkChangeSetResult.inserts());
    assertSame(deletesResult, actualMkChangeSetResult.updates());
  }

  /**
   * Test {@link UsageInfoUtilities#mkChangeSet(Set, Set)}.
   *
   * <p>Method under test: {@link UsageInfoUtilities#mkChangeSet(Set, Set)}
   */
  @Test
  @DisplayName("Test mkChangeSet(Set, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemChangeSet UsageInfoUtilities.mkChangeSet(Set, Set)"})
  void testMkChangeSet4() {
    // Arrange
    HashSet<UsageInfo> base = new HashSet<>();

    HashSet<UsageInfo> replacements = new HashSet<>();
    replacements.add(
        ImmutableUsageInfo.builder()
            .description("")
            .isSelected(false)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualMkChangeSetResult =
        UsageInfoUtilities.mkChangeSet(base, replacements);

    // Assert
    assertTrue(actualMkChangeSetResult instanceof ImmutableSystemChangeSet);
    List<UsageKind> deletesResult = actualMkChangeSetResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualMkChangeSetResult.inserts());
    assertSame(deletesResult, actualMkChangeSetResult.updates());
  }

  /**
   * Test {@link UsageInfoUtilities#mkChangeSet(Set, Set)}.
   *
   * <ul>
   *   <li>Then return deletes Empty.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfoUtilities#mkChangeSet(Set, Set)}
   */
  @Test
  @DisplayName("Test mkChangeSet(Set, Set); then return deletes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemChangeSet UsageInfoUtilities.mkChangeSet(Set, Set)"})
  void testMkChangeSet_thenReturnDeletesEmpty() {
    // Arrange
    HashSet<UsageInfo> base = new HashSet<>();
    base.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualMkChangeSetResult =
        UsageInfoUtilities.mkChangeSet(base, new HashSet<>());

    // Assert
    assertTrue(actualMkChangeSetResult instanceof ImmutableSystemChangeSet);
    List<UsageKind> deletesResult = actualMkChangeSetResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualMkChangeSetResult.inserts());
    assertSame(deletesResult, actualMkChangeSetResult.updates());
  }

  /**
   * Test {@link UsageInfoUtilities#mkChangeSet(Set, Set)}.
   *
   * <ul>
   *   <li>Then return deletes Empty.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfoUtilities#mkChangeSet(Set, Set)}
   */
  @Test
  @DisplayName("Test mkChangeSet(Set, Set); then return deletes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemChangeSet UsageInfoUtilities.mkChangeSet(Set, Set)"})
  void testMkChangeSet_thenReturnDeletesEmpty2() {
    // Arrange
    HashSet<UsageInfo> base = new HashSet<>();
    base.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    HashSet<UsageInfo> replacements = new HashSet<>();
    replacements.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualMkChangeSetResult =
        UsageInfoUtilities.mkChangeSet(base, replacements);

    // Assert
    assertTrue(actualMkChangeSetResult instanceof ImmutableSystemChangeSet);
    List<UsageKind> deletesResult = actualMkChangeSetResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualMkChangeSetResult.inserts());
    assertSame(deletesResult, actualMkChangeSetResult.updates());
  }

  /**
   * Test {@link UsageInfoUtilities#mkChangeSet(Set, Set)}.
   *
   * <ul>
   *   <li>Then return deletes size is one.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfoUtilities#mkChangeSet(Set, Set)}
   */
  @Test
  @DisplayName("Test mkChangeSet(Set, Set); then return deletes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemChangeSet UsageInfoUtilities.mkChangeSet(Set, Set)"})
  void testMkChangeSet_thenReturnDeletesSizeIsOne() {
    // Arrange
    HashSet<UsageInfo> base = new HashSet<>();

    HashSet<UsageInfo> replacements = new HashSet<>();
    replacements.add(
        ImmutableUsageInfo.builder()
            .description("")
            .isSelected(false)
            .kind(UsageKind.MODIFIER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualMkChangeSetResult =
        UsageInfoUtilities.mkChangeSet(base, replacements);

    // Assert
    assertTrue(actualMkChangeSetResult instanceof ImmutableSystemChangeSet);
    List<UsageKind> deletesResult = actualMkChangeSetResult.deletes();
    assertEquals(1, deletesResult.size());
    assertEquals(UsageKind.MODIFIER, deletesResult.get(0));
    List<UsageInfo> insertsResult = actualMkChangeSetResult.inserts();
    assertTrue(insertsResult.isEmpty());
    assertSame(insertsResult, actualMkChangeSetResult.updates());
  }

  /**
   * Test {@link UsageInfoUtilities#mkChangeSet(Set, Set)}.
   *
   * <ul>
   *   <li>Then return deletes size is one.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfoUtilities#mkChangeSet(Set, Set)}
   */
  @Test
  @DisplayName("Test mkChangeSet(Set, Set); then return deletes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemChangeSet UsageInfoUtilities.mkChangeSet(Set, Set)"})
  void testMkChangeSet_thenReturnDeletesSizeIsOne2() {
    // Arrange
    HashSet<UsageInfo> base = new HashSet<>();
    base.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.MODIFIER)
            .build());

    HashSet<UsageInfo> replacements = new HashSet<>();
    replacements.add(
        ImmutableUsageInfo.builder()
            .description("")
            .isSelected(false)
            .kind(UsageKind.MODIFIER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualMkChangeSetResult =
        UsageInfoUtilities.mkChangeSet(base, replacements);

    // Assert
    assertTrue(actualMkChangeSetResult instanceof ImmutableSystemChangeSet);
    List<UsageKind> deletesResult = actualMkChangeSetResult.deletes();
    assertEquals(1, deletesResult.size());
    assertEquals(UsageKind.MODIFIER, deletesResult.get(0));
    List<UsageInfo> insertsResult = actualMkChangeSetResult.inserts();
    assertTrue(insertsResult.isEmpty());
    assertSame(insertsResult, actualMkChangeSetResult.updates());
  }

  /**
   * Test {@link UsageInfoUtilities#mkChangeSet(Set, Set)}.
   *
   * <ul>
   *   <li>Then return inserts first description is empty string.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfoUtilities#mkChangeSet(Set, Set)}
   */
  @Test
  @DisplayName("Test mkChangeSet(Set, Set); then return inserts first description is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemChangeSet UsageInfoUtilities.mkChangeSet(Set, Set)"})
  void testMkChangeSet_thenReturnInsertsFirstDescriptionIsEmptyString() {
    // Arrange
    HashSet<UsageInfo> base = new HashSet<>();

    HashSet<UsageInfo> replacements = new HashSet<>();
    replacements.add(
        ImmutableUsageInfo.builder()
            .description("")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualMkChangeSetResult =
        UsageInfoUtilities.mkChangeSet(base, replacements);

    // Assert
    assertTrue(actualMkChangeSetResult instanceof ImmutableSystemChangeSet);
    List<UsageInfo> insertsResult = actualMkChangeSetResult.inserts();
    assertEquals(1, insertsResult.size());
    UsageInfo getResult = insertsResult.get(0);
    assertTrue(getResult instanceof ImmutableUsageInfo);
    assertEquals("", getResult.description());
    assertEquals(UsageKind.CONSUMER, getResult.kind());
    assertTrue(getResult.isSelected());
  }

  /**
   * Test {@link UsageInfoUtilities#mkChangeSet(Set, Set)}.
   *
   * <ul>
   *   <li>Then return inserts first kind is {@code CONSUMER}.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfoUtilities#mkChangeSet(Set, Set)}
   */
  @Test
  @DisplayName("Test mkChangeSet(Set, Set); then return inserts first kind is 'CONSUMER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemChangeSet UsageInfoUtilities.mkChangeSet(Set, Set)"})
  void testMkChangeSet_thenReturnInsertsFirstKindIsConsumer() {
    // Arrange
    HashSet<UsageInfo> base = new HashSet<>();

    HashSet<UsageInfo> replacements = new HashSet<>();
    replacements.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualMkChangeSetResult =
        UsageInfoUtilities.mkChangeSet(base, replacements);

    // Assert
    assertTrue(actualMkChangeSetResult instanceof ImmutableSystemChangeSet);
    List<UsageInfo> insertsResult = actualMkChangeSetResult.inserts();
    assertEquals(1, insertsResult.size());
    UsageInfo getResult = insertsResult.get(0);
    assertTrue(getResult instanceof ImmutableUsageInfo);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(UsageKind.CONSUMER, getResult.kind());
    assertTrue(getResult.isSelected());
  }

  /**
   * Test {@link UsageInfoUtilities#mkChangeSet(Set, Set)}.
   *
   * <ul>
   *   <li>Then return inserts first kind is {@code MODIFIER}.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfoUtilities#mkChangeSet(Set, Set)}
   */
  @Test
  @DisplayName("Test mkChangeSet(Set, Set); then return inserts first kind is 'MODIFIER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemChangeSet UsageInfoUtilities.mkChangeSet(Set, Set)"})
  void testMkChangeSet_thenReturnInsertsFirstKindIsModifier() {
    // Arrange
    HashSet<UsageInfo> base = new HashSet<>();

    HashSet<UsageInfo> replacements = new HashSet<>();
    replacements.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.MODIFIER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualMkChangeSetResult =
        UsageInfoUtilities.mkChangeSet(base, replacements);

    // Assert
    assertTrue(actualMkChangeSetResult instanceof ImmutableSystemChangeSet);
    List<UsageInfo> insertsResult = actualMkChangeSetResult.inserts();
    assertEquals(1, insertsResult.size());
    UsageInfo getResult = insertsResult.get(0);
    assertTrue(getResult instanceof ImmutableUsageInfo);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(UsageKind.MODIFIER, getResult.kind());
    assertTrue(getResult.isSelected());
  }

  /**
   * Test {@link UsageInfoUtilities#mkChangeSet(Set, Set)}.
   *
   * <ul>
   *   <li>Then return inserts first kind is {@code ORIGINATOR}.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfoUtilities#mkChangeSet(Set, Set)}
   */
  @Test
  @DisplayName("Test mkChangeSet(Set, Set); then return inserts first kind is 'ORIGINATOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemChangeSet UsageInfoUtilities.mkChangeSet(Set, Set)"})
  void testMkChangeSet_thenReturnInsertsFirstKindIsOriginator() {
    // Arrange
    HashSet<UsageInfo> base = new HashSet<>();
    base.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    HashSet<UsageInfo> replacements = new HashSet<>();
    replacements.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.ORIGINATOR)
            .build());
    replacements.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualMkChangeSetResult =
        UsageInfoUtilities.mkChangeSet(base, replacements);

    // Assert
    assertTrue(actualMkChangeSetResult instanceof ImmutableSystemChangeSet);
    List<UsageInfo> insertsResult = actualMkChangeSetResult.inserts();
    assertEquals(1, insertsResult.size());
    UsageInfo getResult = insertsResult.get(0);
    assertTrue(getResult instanceof ImmutableUsageInfo);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(UsageKind.ORIGINATOR, getResult.kind());
    assertTrue(getResult.isSelected());
  }

  /**
   * Test {@link UsageInfoUtilities#mkChangeSet(Set, Set)}.
   *
   * <ul>
   *   <li>Then return not inserts first Selected.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfoUtilities#mkChangeSet(Set, Set)}
   */
  @Test
  @DisplayName("Test mkChangeSet(Set, Set); then return not inserts first Selected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemChangeSet UsageInfoUtilities.mkChangeSet(Set, Set)"})
  void testMkChangeSet_thenReturnNotInsertsFirstSelected() {
    // Arrange
    HashSet<UsageInfo> base = new HashSet<>();

    HashSet<UsageInfo> replacements = new HashSet<>();
    replacements.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(false)
            .kind(UsageKind.MODIFIER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualMkChangeSetResult =
        UsageInfoUtilities.mkChangeSet(base, replacements);

    // Assert
    assertTrue(actualMkChangeSetResult instanceof ImmutableSystemChangeSet);
    List<UsageInfo> insertsResult = actualMkChangeSetResult.inserts();
    assertEquals(1, insertsResult.size());
    UsageInfo getResult = insertsResult.get(0);
    assertTrue(getResult instanceof ImmutableUsageInfo);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(UsageKind.MODIFIER, getResult.kind());
    assertFalse(getResult.isSelected());
  }

  /**
   * Test {@link UsageInfoUtilities#mkChangeSet(Set, Set)}.
   *
   * <ul>
   *   <li>Then return updates size is one.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfoUtilities#mkChangeSet(Set, Set)}
   */
  @Test
  @DisplayName("Test mkChangeSet(Set, Set); then return updates size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemChangeSet UsageInfoUtilities.mkChangeSet(Set, Set)"})
  void testMkChangeSet_thenReturnUpdatesSizeIsOne() {
    // Arrange
    HashSet<UsageInfo> base = new HashSet<>();
    base.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    HashSet<UsageInfo> replacements = new HashSet<>();
    replacements.add(
        ImmutableUsageInfo.builder()
            .description("xs cannot be null")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualMkChangeSetResult =
        UsageInfoUtilities.mkChangeSet(base, replacements);

    // Assert
    assertTrue(actualMkChangeSetResult instanceof ImmutableSystemChangeSet);
    List<UsageInfo> updatesResult = actualMkChangeSetResult.updates();
    assertEquals(1, updatesResult.size());
    UsageInfo getResult = updatesResult.get(0);
    assertTrue(getResult instanceof ImmutableUsageInfo);
    assertEquals("xs cannot be null", getResult.description());
    assertEquals(UsageKind.CONSUMER, getResult.kind());
    assertTrue(getResult.isSelected());
  }

  /**
   * Test {@link UsageInfoUtilities#mkChangeSet(Set, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return deletes Empty.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfoUtilities#mkChangeSet(Set, Set)}
   */
  @Test
  @DisplayName("Test mkChangeSet(Set, Set); when HashSet(); then return deletes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemChangeSet UsageInfoUtilities.mkChangeSet(Set, Set)"})
  void testMkChangeSet_whenHashSet_thenReturnDeletesEmpty() {
    // Arrange
    HashSet<UsageInfo> base = new HashSet<>();

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualMkChangeSetResult =
        UsageInfoUtilities.mkChangeSet(base, new HashSet<>());

    // Assert
    assertTrue(actualMkChangeSetResult instanceof ImmutableSystemChangeSet);
    List<UsageKind> deletesResult = actualMkChangeSetResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualMkChangeSetResult.inserts());
    assertSame(deletesResult, actualMkChangeSetResult.updates());
  }
}
