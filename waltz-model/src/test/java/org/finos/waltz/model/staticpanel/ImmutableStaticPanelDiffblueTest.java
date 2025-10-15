package org.finos.waltz.model.staticpanel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.staticpanel.ImmutableStaticPanel.Builder;
import org.finos.waltz.model.staticpanel.ImmutableStaticPanel.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableStaticPanelDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#encoding(ContentKind)}
   *   <li>{@link Builder#icon(String)}
   *   <li>{@link Builder#title(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableStaticPanel Builder.build()",
    "Builder Builder.encoding(ContentKind)",
    "Builder Builder.icon(String)",
    "Builder Builder.title(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableStaticPanel actualImmutableStaticPanel =
        actualIdResult.id(id).priority(1).title("Dr").build();

    // Assert
    assertEquals("Dr", actualImmutableStaticPanel.title());
    assertEquals("Group", actualImmutableStaticPanel.group());
    assertEquals("Icon", actualImmutableStaticPanel.icon());
    assertEquals("Not all who wander are lost", actualImmutableStaticPanel.content());
    assertEquals(1, actualImmutableStaticPanel.priority());
    assertEquals(12, actualImmutableStaticPanel.width());
    assertEquals(ContentKind.HTML, actualImmutableStaticPanel.encoding());
  }

  /**
   * Test Builder {@link Builder#content(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#content(String)}
   */
  @Test
  @DisplayName(
      "Test Builder content(String); when 'Not all who wander are lost'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.content(String)"})
  void testBuilderContent_whenNotAllWhoWanderAreLost_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();

    // Act
    Builder actualContentResult = builderResult.content("Not all who wander are lost");

    // Assert
    assertSame(builderResult, actualContentResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();
    ImmutableStaticPanel instance =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableStaticPanel actualImmutableStaticPanel = builderResult.build();
    assertEquals(instance, actualImmutableStaticPanel);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider2() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();
    ImmutableStaticPanel instance =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon(null)
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableStaticPanel actualImmutableStaticPanel = builderResult.build();
    assertEquals(instance, actualImmutableStaticPanel);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider3() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();
    ImmutableStaticPanel instance =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title(null)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableStaticPanel actualImmutableStaticPanel = builderResult.build();
    assertEquals(instance, actualImmutableStaticPanel);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   *   <li>Then calls {@link IdProvider#id()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty; then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty_thenCallsId() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();

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
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(StaticPanel)} with {@code StaticPanel}.
   *
   * <p>Method under test: {@link Builder#from(StaticPanel)}
   */
  @Test
  @DisplayName("Test Builder from(StaticPanel) with 'StaticPanel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(StaticPanel)"})
  void testBuilderFromWithStaticPanel() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();
    ImmutableStaticPanel instance =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableStaticPanel actualImmutableStaticPanel = builderResult.build();
    assertEquals(instance, actualImmutableStaticPanel);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(StaticPanel)} with {@code StaticPanel}.
   *
   * <p>Method under test: {@link Builder#from(StaticPanel)}
   */
  @Test
  @DisplayName("Test Builder from(StaticPanel) with 'StaticPanel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(StaticPanel)"})
  void testBuilderFromWithStaticPanel2() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();
    ImmutableStaticPanel instance =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon(null)
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableStaticPanel actualImmutableStaticPanel = builderResult.build();
    assertEquals(instance, actualImmutableStaticPanel);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(StaticPanel)} with {@code StaticPanel}.
   *
   * <p>Method under test: {@link Builder#from(StaticPanel)}
   */
  @Test
  @DisplayName("Test Builder from(StaticPanel) with 'StaticPanel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(StaticPanel)"})
  void testBuilderFromWithStaticPanel3() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();
    ImmutableStaticPanel instance =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title(null)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableStaticPanel actualImmutableStaticPanel = builderResult.build();
    assertEquals(instance, actualImmutableStaticPanel);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#group(String)}.
   *
   * <ul>
   *   <li>When {@code Group}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#group(String)}
   */
  @Test
  @DisplayName("Test Builder group(String); when 'Group'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.group(String)"})
  void testBuilderGroup_whenGroup_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();

    // Act
    Builder actualGroupResult = builderResult.group("Group");

    // Assert
    assertSame(builderResult, actualGroupResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#priority(int)}.
   *
   * <p>Method under test: {@link Builder#priority(int)}
   */
  @Test
  @DisplayName("Test Builder priority(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.priority(int)"})
  void testBuilderPriority() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();

    // Act
    Builder actualPriorityResult = builderResult.priority(1);

    // Assert
    assertSame(builderResult, actualPriorityResult);
  }

  /**
   * Test Builder {@link Builder#width(int)}.
   *
   * <p>Method under test: {@link Builder#width(int)}
   */
  @Test
  @DisplayName("Test Builder width(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.width(int)"})
  void testBuilderWidth() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();

    // Act
    Builder actualWidthResult = builderResult.width(1);

    // Assert
    assertSame(builderResult, actualWidthResult);
  }

  /**
   * Test {@link ImmutableStaticPanel#copyOf(StaticPanel)}.
   *
   * <ul>
   *   <li>Then return title is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#copyOf(StaticPanel)}
   */
  @Test
  @DisplayName("Test copyOf(StaticPanel); then return title is 'Dr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.copyOf(StaticPanel)"})
  void testCopyOf_thenReturnTitleIsDr() {
    // Arrange
    ImmutableStaticPanel instance =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();

    // Act
    ImmutableStaticPanel actualCopyOfResult = ImmutableStaticPanel.copyOf(instance);

    // Assert
    assertEquals("Dr", actualCopyOfResult.title());
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Icon", actualCopyOfResult.icon());
    assertEquals("Not all who wander are lost", actualCopyOfResult.content());
    assertEquals(1, actualCopyOfResult.priority());
    assertEquals(12, actualCopyOfResult.width());
    assertEquals(ContentKind.HTML, actualCopyOfResult.encoding());
  }

  /**
   * Test {@link ImmutableStaticPanel#encoding()}.
   *
   * <p>Method under test: {@link ImmutableStaticPanel#encoding()}
   */
  @Test
  @DisplayName("Test encoding()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ContentKind ImmutableStaticPanel.encoding()"})
  void testEncoding() {
    // Arrange, Act and Assert
    assertEquals(
        ContentKind.HTML,
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build()
            .encoding());
  }

  /**
   * Test {@link ImmutableStaticPanel#equals(Object)}, and {@link ImmutableStaticPanel#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableStaticPanel#equals(Object)}
   *   <li>{@link ImmutableStaticPanel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableStaticPanel.equals(Object)",
    "int ImmutableStaticPanel.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();
    ImmutableStaticPanel immutableStaticPanel2 =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();

    // Act and Assert
    assertEquals(immutableStaticPanel, immutableStaticPanel2);
    assertEquals(immutableStaticPanel.hashCode(), immutableStaticPanel2.hashCode());
  }

  /**
   * Test {@link ImmutableStaticPanel#equals(Object)}, and {@link ImmutableStaticPanel#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableStaticPanel#equals(Object)}
   *   <li>{@link ImmutableStaticPanel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableStaticPanel.equals(Object)",
    "int ImmutableStaticPanel.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();

    // Act and Assert
    assertEquals(immutableStaticPanel, immutableStaticPanel);
    int expectedHashCodeResult = immutableStaticPanel.hashCode();
    assertEquals(expectedHashCodeResult, immutableStaticPanel.hashCode());
  }

  /**
   * Test {@link ImmutableStaticPanel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableStaticPanel.equals(Object)",
    "int ImmutableStaticPanel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Group")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableStaticPanel,
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableStaticPanel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableStaticPanel.equals(Object)",
    "int ImmutableStaticPanel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.MARKDOWN)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableStaticPanel,
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableStaticPanel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableStaticPanel.equals(Object)",
    "int ImmutableStaticPanel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Not all who wander are lost")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableStaticPanel,
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableStaticPanel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableStaticPanel.equals(Object)",
    "int ImmutableStaticPanel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Group")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableStaticPanel,
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableStaticPanel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableStaticPanel.equals(Object)",
    "int ImmutableStaticPanel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(2L)
            .priority(1)
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableStaticPanel,
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableStaticPanel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableStaticPanel.equals(Object)",
    "int ImmutableStaticPanel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(12)
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableStaticPanel,
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableStaticPanel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableStaticPanel.equals(Object)",
    "int ImmutableStaticPanel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Mr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableStaticPanel,
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableStaticPanel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableStaticPanel.equals(Object)",
    "int ImmutableStaticPanel.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableStaticPanel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableStaticPanel.equals(Object)",
    "int ImmutableStaticPanel.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build(),
        "Different type to ImmutableStaticPanel");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableStaticPanel#content()}
   *   <li>{@link ImmutableStaticPanel#group()}
   *   <li>{@link ImmutableStaticPanel#icon()}
   *   <li>{@link ImmutableStaticPanel#priority()}
   *   <li>{@link ImmutableStaticPanel#title()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableStaticPanel.content()",
    "String ImmutableStaticPanel.group()",
    "String ImmutableStaticPanel.icon()",
    "int ImmutableStaticPanel.priority()",
    "String ImmutableStaticPanel.title()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();

    // Act
    String actualContentResult = immutableStaticPanel.content();
    String actualGroupResult = immutableStaticPanel.group();
    String actualIconResult = immutableStaticPanel.icon();
    int actualPriorityResult = immutableStaticPanel.priority();

    // Assert
    assertEquals("Dr", immutableStaticPanel.title());
    assertEquals("Group", actualGroupResult);
    assertEquals("Icon", actualIconResult);
    assertEquals("Not all who wander are lost", actualContentResult);
    assertEquals(1, actualPriorityResult);
  }

  /**
   * Test {@link ImmutableStaticPanel#id()}.
   *
   * <p>Method under test: {@link ImmutableStaticPanel#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableStaticPanel.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#content()}.
   *
   * <p>Method under test: {@link Json#content()}
   */
  @Test
  @DisplayName("Test Json content()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.content()"})
  void testJsonContent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().content());
  }

  /**
   * Test Json {@link Json#encoding()}.
   *
   * <p>Method under test: {@link Json#encoding()}
   */
  @Test
  @DisplayName("Test Json encoding()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ContentKind Json.encoding()"})
  void testJsonEncoding() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().encoding());
  }

  /**
   * Test Json {@link Json#group()}.
   *
   * <p>Method under test: {@link Json#group()}
   */
  @Test
  @DisplayName("Test Json group()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.group()"})
  void testJsonGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().group());
  }

  /**
   * Test Json {@link Json#icon()}.
   *
   * <p>Method under test: {@link Json#icon()}
   */
  @Test
  @DisplayName("Test Json icon()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.icon()"})
  void testJsonIcon() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().icon());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.content);
    assertNull(actualJson.group);
    assertNull(actualJson.icon);
    assertNull(actualJson.title);
    assertNull(actualJson.encoding);
    assertEquals(0, actualJson.priority);
    assertEquals(0, actualJson.width);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.priorityIsSet);
    assertFalse(actualJson.widthIsSet);
  }

  /**
   * Test Json {@link Json#priority()}.
   *
   * <p>Method under test: {@link Json#priority()}
   */
  @Test
  @DisplayName("Test Json priority()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.priority()"})
  void testJsonPriority() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().priority());
  }

  /**
   * Test Json {@link Json#setPriority(int)}.
   *
   * <p>Method under test: {@link Json#setPriority(int)}
   */
  @Test
  @DisplayName("Test Json setPriority(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPriority(int)"})
  void testJsonSetPriority() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPriority(1);

    // Assert
    assertEquals(1, json.priority);
    assertTrue(json.priorityIsSet);
  }

  /**
   * Test Json {@link Json#setWidth(int)}.
   *
   * <p>Method under test: {@link Json#setWidth(int)}
   */
  @Test
  @DisplayName("Test Json setWidth(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setWidth(int)"})
  void testJsonSetWidth() {
    // Arrange
    Json json = new Json();

    // Act
    json.setWidth(1);

    // Assert
    assertEquals(1, json.width);
    assertTrue(json.widthIsSet);
  }

  /**
   * Test Json {@link Json#title()}.
   *
   * <p>Method under test: {@link Json#title()}
   */
  @Test
  @DisplayName("Test Json title()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.title()"})
  void testJsonTitle() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().title());
  }

  /**
   * Test Json {@link Json#width()}.
   *
   * <p>Method under test: {@link Json#width()}
   */
  @Test
  @DisplayName("Test Json width()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.width()"})
  void testJsonWidth() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().width());
  }

  /**
   * Test {@link ImmutableStaticPanel#toString()}.
   *
   * <p>Method under test: {@link ImmutableStaticPanel#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableStaticPanel.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "StaticPanel{id=1, title=Dr, icon=Icon, group=Group, content=Not all who wander are lost, priority=1,"
            + " width=12, encoding=HTML}",
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableStaticPanel#toString()}.
   *
   * <p>Method under test: {@link ImmutableStaticPanel#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableStaticPanel.toString()"})
  void testToString2() {
    // Arrange, Act and Assert
    assertEquals(
        "StaticPanel{id=1, title=Dr, group=Group, content=Not all who wander are lost, priority=1, width=12,"
            + " encoding=HTML}",
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon(null)
            .id(1L)
            .priority(1)
            .title("Dr")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableStaticPanel#toString()}.
   *
   * <p>Method under test: {@link ImmutableStaticPanel#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableStaticPanel.toString()"})
  void testToString3() {
    // Arrange, Act and Assert
    assertEquals(
        "StaticPanel{id=1, icon=Icon, group=Group, content=Not all who wander are lost, priority=1, width=12,"
            + " encoding=HTML}",
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title(null)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableStaticPanel#width()}.
   *
   * <p>Method under test: {@link ImmutableStaticPanel#width()}
   */
  @Test
  @DisplayName("Test width()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImmutableStaticPanel.width()"})
  void testWidth() {
    // Arrange, Act and Assert
    assertEquals(
        12,
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build()
            .width());
  }

  /**
   * Test {@link ImmutableStaticPanel#withContent(String)}.
   *
   * <p>Method under test: {@link ImmutableStaticPanel#withContent(String)}
   */
  @Test
  @DisplayName("Test withContent(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.withContent(String)"})
  void testWithContent() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("42")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();

    // Act
    ImmutableStaticPanel actualWithContentResult = immutableStaticPanel.withContent("42");

    // Assert
    assertSame(immutableStaticPanel, actualWithContentResult);
  }

  /**
   * Test {@link ImmutableStaticPanel#withContent(String)}.
   *
   * <ul>
   *   <li>Then return content is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#withContent(String)}
   */
  @Test
  @DisplayName("Test withContent(String); then return content is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.withContent(String)"})
  void testWithContent_thenReturnContentIs42() {
    // Arrange and Act
    ImmutableStaticPanel actualWithContentResult =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build()
            .withContent("42");

    // Assert
    assertEquals("42", actualWithContentResult.content());
    assertEquals("Dr", actualWithContentResult.title());
    assertEquals("Group", actualWithContentResult.group());
    assertEquals("Icon", actualWithContentResult.icon());
    assertEquals(1, actualWithContentResult.priority());
    assertEquals(12, actualWithContentResult.width());
    assertEquals(ContentKind.HTML, actualWithContentResult.encoding());
  }

  /**
   * Test {@link ImmutableStaticPanel#withEncoding(ContentKind)}.
   *
   * <p>Method under test: {@link ImmutableStaticPanel#withEncoding(ContentKind)}
   */
  @Test
  @DisplayName("Test withEncoding(ContentKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.withEncoding(ContentKind)"})
  void testWithEncoding() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();

    // Act
    ImmutableStaticPanel actualWithEncodingResult =
        immutableStaticPanel.withEncoding(ContentKind.HTML);

    // Assert
    assertSame(immutableStaticPanel, actualWithEncodingResult);
  }

  /**
   * Test {@link ImmutableStaticPanel#withEncoding(ContentKind)}.
   *
   * <ul>
   *   <li>Then return title is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#withEncoding(ContentKind)}
   */
  @Test
  @DisplayName("Test withEncoding(ContentKind); then return title is 'Dr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.withEncoding(ContentKind)"})
  void testWithEncoding_thenReturnTitleIsDr() {
    // Arrange and Act
    ImmutableStaticPanel actualWithEncodingResult =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.MARKDOWN)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build()
            .withEncoding(ContentKind.HTML);

    // Assert
    assertEquals("Dr", actualWithEncodingResult.title());
    assertEquals("Group", actualWithEncodingResult.group());
    assertEquals("Icon", actualWithEncodingResult.icon());
    assertEquals("Not all who wander are lost", actualWithEncodingResult.content());
    assertEquals(1, actualWithEncodingResult.priority());
    assertEquals(12, actualWithEncodingResult.width());
    assertEquals(ContentKind.HTML, actualWithEncodingResult.encoding());
  }

  /**
   * Test {@link ImmutableStaticPanel#withGroup(String)}.
   *
   * <p>Method under test: {@link ImmutableStaticPanel#withGroup(String)}
   */
  @Test
  @DisplayName("Test withGroup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.withGroup(String)"})
  void testWithGroup() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("42")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();

    // Act
    ImmutableStaticPanel actualWithGroupResult = immutableStaticPanel.withGroup("42");

    // Assert
    assertSame(immutableStaticPanel, actualWithGroupResult);
  }

  /**
   * Test {@link ImmutableStaticPanel#withGroup(String)}.
   *
   * <ul>
   *   <li>Then return group is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#withGroup(String)}
   */
  @Test
  @DisplayName("Test withGroup(String); then return group is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.withGroup(String)"})
  void testWithGroup_thenReturnGroupIs42() {
    // Arrange and Act
    ImmutableStaticPanel actualWithGroupResult =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build()
            .withGroup("42");

    // Assert
    assertEquals("42", actualWithGroupResult.group());
    assertEquals("Dr", actualWithGroupResult.title());
    assertEquals("Icon", actualWithGroupResult.icon());
    assertEquals("Not all who wander are lost", actualWithGroupResult.content());
    assertEquals(1, actualWithGroupResult.priority());
    assertEquals(12, actualWithGroupResult.width());
    assertEquals(ContentKind.HTML, actualWithGroupResult.encoding());
  }

  /**
   * Test {@link ImmutableStaticPanel#withIcon(String)}.
   *
   * <p>Method under test: {@link ImmutableStaticPanel#withIcon(String)}
   */
  @Test
  @DisplayName("Test withIcon(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.withIcon(String)"})
  void testWithIcon() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("42")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();

    // Act
    ImmutableStaticPanel actualWithIconResult = immutableStaticPanel.withIcon("42");

    // Assert
    assertSame(immutableStaticPanel, actualWithIconResult);
  }

  /**
   * Test {@link ImmutableStaticPanel#withIcon(String)}.
   *
   * <ul>
   *   <li>Then return icon is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#withIcon(String)}
   */
  @Test
  @DisplayName("Test withIcon(String); then return icon is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.withIcon(String)"})
  void testWithIcon_thenReturnIconIs42() {
    // Arrange and Act
    ImmutableStaticPanel actualWithIconResult =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build()
            .withIcon("42");

    // Assert
    assertEquals("42", actualWithIconResult.icon());
    assertEquals("Dr", actualWithIconResult.title());
    assertEquals("Group", actualWithIconResult.group());
    assertEquals("Not all who wander are lost", actualWithIconResult.content());
    assertEquals(1, actualWithIconResult.priority());
    assertEquals(12, actualWithIconResult.width());
    assertEquals(ContentKind.HTML, actualWithIconResult.encoding());
  }

  /**
   * Test {@link ImmutableStaticPanel#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableStaticPanel#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableStaticPanel actualWithIdResult = immutableStaticPanel.withId(optional);

    // Assert
    assertSame(immutableStaticPanel, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableStaticPanel#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return title is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return title is 'Dr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.withId(Optional)"})
  void testWithIdWithOptional_thenReturnTitleIsDr() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(2L)
            .priority(1)
            .title("Dr")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableStaticPanel actualWithIdResult = immutableStaticPanel.withId(optional);

    // Assert
    assertEquals("Dr", actualWithIdResult.title());
    assertEquals("Group", actualWithIdResult.group());
    assertEquals("Icon", actualWithIdResult.icon());
    assertEquals("Not all who wander are lost", actualWithIdResult.content());
    assertEquals(1, actualWithIdResult.priority());
    assertEquals(12, actualWithIdResult.width());
    assertEquals(ContentKind.HTML, actualWithIdResult.encoding());
  }

  /**
   * Test {@link ImmutableStaticPanel#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableStaticPanel#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();

    // Act
    ImmutableStaticPanel actualWithIdResult = immutableStaticPanel.withId(1L);

    // Assert
    assertSame(immutableStaticPanel, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableStaticPanel#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return title is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return title is 'Dr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnTitleIsDr() {
    // Arrange and Act
    ImmutableStaticPanel actualWithIdResult =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build()
            .withId(42L);

    // Assert
    assertEquals("Dr", actualWithIdResult.title());
    assertEquals("Group", actualWithIdResult.group());
    assertEquals("Icon", actualWithIdResult.icon());
    assertEquals("Not all who wander are lost", actualWithIdResult.content());
    assertEquals(1, actualWithIdResult.priority());
    assertEquals(12, actualWithIdResult.width());
    assertEquals(ContentKind.HTML, actualWithIdResult.encoding());
  }

  /**
   * Test {@link ImmutableStaticPanel#withPriority(int)}.
   *
   * <p>Method under test: {@link ImmutableStaticPanel#withPriority(int)}
   */
  @Test
  @DisplayName("Test withPriority(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.withPriority(int)"})
  void testWithPriority() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(42)
            .title("Dr")
            .build();

    // Act
    ImmutableStaticPanel actualWithPriorityResult = immutableStaticPanel.withPriority(42);

    // Assert
    assertSame(immutableStaticPanel, actualWithPriorityResult);
  }

  /**
   * Test {@link ImmutableStaticPanel#withPriority(int)}.
   *
   * <ul>
   *   <li>Then return title is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#withPriority(int)}
   */
  @Test
  @DisplayName("Test withPriority(int); then return title is 'Dr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.withPriority(int)"})
  void testWithPriority_thenReturnTitleIsDr() {
    // Arrange and Act
    ImmutableStaticPanel actualWithPriorityResult =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build()
            .withPriority(42);

    // Assert
    assertEquals("Dr", actualWithPriorityResult.title());
    assertEquals("Group", actualWithPriorityResult.group());
    assertEquals("Icon", actualWithPriorityResult.icon());
    assertEquals("Not all who wander are lost", actualWithPriorityResult.content());
    assertEquals(12, actualWithPriorityResult.width());
    assertEquals(42, actualWithPriorityResult.priority());
    assertEquals(ContentKind.HTML, actualWithPriorityResult.encoding());
  }

  /**
   * Test {@link ImmutableStaticPanel#withTitle(String)}.
   *
   * <p>Method under test: {@link ImmutableStaticPanel#withTitle(String)}
   */
  @Test
  @DisplayName("Test withTitle(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.withTitle(String)"})
  void testWithTitle() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("42")
            .build();

    // Act
    ImmutableStaticPanel actualWithTitleResult = immutableStaticPanel.withTitle("42");

    // Assert
    assertSame(immutableStaticPanel, actualWithTitleResult);
  }

  /**
   * Test {@link ImmutableStaticPanel#withTitle(String)}.
   *
   * <ul>
   *   <li>Then return title is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#withTitle(String)}
   */
  @Test
  @DisplayName("Test withTitle(String); then return title is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.withTitle(String)"})
  void testWithTitle_thenReturnTitleIs42() {
    // Arrange and Act
    ImmutableStaticPanel actualWithTitleResult =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build()
            .withTitle("42");

    // Assert
    assertEquals("42", actualWithTitleResult.title());
    assertEquals("Group", actualWithTitleResult.group());
    assertEquals("Icon", actualWithTitleResult.icon());
    assertEquals("Not all who wander are lost", actualWithTitleResult.content());
    assertEquals(1, actualWithTitleResult.priority());
    assertEquals(12, actualWithTitleResult.width());
    assertEquals(ContentKind.HTML, actualWithTitleResult.encoding());
  }

  /**
   * Test {@link ImmutableStaticPanel#withWidth(int)}.
   *
   * <p>Method under test: {@link ImmutableStaticPanel#withWidth(int)}
   */
  @Test
  @DisplayName("Test withWidth(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.withWidth(int)"})
  void testWithWidth() {
    // Arrange
    ImmutableStaticPanel immutableStaticPanel =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build();

    // Act
    ImmutableStaticPanel actualWithWidthResult = immutableStaticPanel.withWidth(12);

    // Assert
    assertSame(immutableStaticPanel, actualWithWidthResult);
  }

  /**
   * Test {@link ImmutableStaticPanel#withWidth(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return title is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStaticPanel#withWidth(int)}
   */
  @Test
  @DisplayName("Test withWidth(int); when forty-two; then return title is 'Dr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStaticPanel ImmutableStaticPanel.withWidth(int)"})
  void testWithWidth_whenFortyTwo_thenReturnTitleIsDr() {
    // Arrange and Act
    ImmutableStaticPanel actualWithWidthResult =
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build()
            .withWidth(42);

    // Assert
    assertEquals("Dr", actualWithWidthResult.title());
    assertEquals("Group", actualWithWidthResult.group());
    assertEquals("Icon", actualWithWidthResult.icon());
    assertEquals("Not all who wander are lost", actualWithWidthResult.content());
    assertEquals(1, actualWithWidthResult.priority());
    assertEquals(42, actualWithWidthResult.width());
    assertEquals(ContentKind.HTML, actualWithWidthResult.encoding());
  }
}
