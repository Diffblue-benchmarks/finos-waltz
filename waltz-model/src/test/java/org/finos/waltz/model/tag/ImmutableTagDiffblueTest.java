package org.finos.waltz.model.tag;

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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.tag.ImmutableTag.Builder;
import org.finos.waltz.model.tag.ImmutableTag.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ImmutableTagDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllTagUsages(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllTagUsages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllTagUsages(Iterable); when ArrayList(); then return builder")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllTagUsages(Iterable)"})
  void testBuilderAddAllTagUsages_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

    // Act
    Builder actualAddAllTagUsagesResult = builderResult.addAllTagUsages(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllTagUsagesResult);
  }

  /**
   * Test Builder {@link Builder#addTagUsages(TagUsage)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableTagUsage.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addTagUsages(TagUsage)}
   */
  @Test
  @DisplayName(
      "Test Builder addTagUsages(TagUsage) with 'element'; when Json (default constructor); then return builder")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addTagUsages(TagUsage)"})
  void testBuilderAddTagUsagesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

    // Act
    Builder actualAddTagUsagesResult = builderResult.addTagUsages(new ImmutableTagUsage.Json());

    // Assert
    assertSame(builderResult, actualAddTagUsagesResult);
  }

  /**
   * Test Builder {@link Builder#addTagUsages(TagUsage[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableTagUsage.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addTagUsages(TagUsage[])}
   */
  @Test
  @DisplayName(
      "Test Builder addTagUsages(TagUsage[]) with 'elements'; when Json (default constructor); then return builder")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addTagUsages(TagUsage[])"})
  void testBuilderAddTagUsagesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

    // Act
    Builder actualAddTagUsagesResult = builderResult.addTagUsages(new ImmutableTagUsage.Json());

    // Assert
    assertSame(builderResult, actualAddTagUsagesResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTag Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult = ImmutableTag.builder().id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutableTag actualImmutableTag =
        actualIdResult.id(id).name("Name").targetKind(EntityKind.ALL).build();

    // Assert
    assertEquals("Name", actualImmutableTag.name());
    assertEquals(EntityKind.ALL, actualImmutableTag.targetKind());
    assertTrue(actualImmutableTag.tagUsages().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();
    ImmutableTag instance =
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build();

    // Act and Assert
    ImmutableTag actualImmutableTag = builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableTag);
    ImmutableTag actualImmutableTag2 = builderResult.build();
    assertEquals(instance, actualImmutableTag2);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

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
   *   <li>Given of forty-two.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of forty-two; when IdProvider id() return of forty-two")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfFortyTwo_whenIdProviderIdReturnOfFortyTwo() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(42L);
    when(instance.id()).thenReturn(ofResult);

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
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();
    ImmutableTag instance =
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build();

    // Act and Assert
    ImmutableTag actualImmutableTag = builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableTag);
    ImmutableTag actualImmutableTag2 = builderResult.build();
    assertEquals(instance, actualImmutableTag2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Tag)} with {@code Tag}.
   *
   * <ul>
   *   <li>Then builder build is builder id one name {@code Name} targetKind {@code ALL} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(Tag)}
   */
  @Test
  @DisplayName(
      "Test Builder from(Tag) with 'Tag'; then builder build is builder id one name 'Name' targetKind 'ALL' build")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Tag)"})
  void testBuilderFromWithTag_thenBuilderBuildIsBuilderIdOneNameNameTargetKindAllBuild() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

    Builder builderResult2 = ImmutableTag.builder();

    ImmutableTagUsage.Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    builderResult2.addTagUsages(
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build());
    ImmutableTag instance = builderResult2.id(1L).name("Name").targetKind(EntityKind.ALL).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableTag actualImmutableTag = builderResult.build();
    assertEquals(instance, actualImmutableTag);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Tag)} with {@code Tag}.
   *
   * <ul>
   *   <li>Then return build is builder id one name {@code Name} targetKind {@code ALL} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(Tag)}
   */
  @Test
  @DisplayName(
      "Test Builder from(Tag) with 'Tag'; then return build is builder id one name 'Name' targetKind 'ALL' build")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Tag)"})
  void testBuilderFromWithTag_thenReturnBuildIsBuilderIdOneNameNameTargetKindAllBuild() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();
    ImmutableTag instance =
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build();

    // Act and Assert
    ImmutableTag actualImmutableTag = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableTag);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

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
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#tagUsages(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#tagUsages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder tagUsages(Iterable); when ArrayList(); then return builder")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.tagUsages(Iterable)"})
  void testBuilderTagUsages_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

    // Act
    Builder actualTagUsagesResult = builderResult.tagUsages(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualTagUsagesResult);
  }

  /**
   * Test Builder {@link Builder#targetKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#targetKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder targetKind(EntityKind)")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetKind(EntityKind)"})
  void testBuilderTargetKind() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

    // Act
    Builder actualTargetKindResult = builderResult.targetKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualTargetKindResult);
  }

  /**
   * Test {@link ImmutableTag#copyOf(Tag)}.
   *
   * <ul>
   *   <li>When builder id one name {@code Name} targetKind {@code ALL} build.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#copyOf(Tag)}
   */
  @Test
  @DisplayName(
      "Test copyOf(Tag); when builder id one name 'Name' targetKind 'ALL' build; then return 'Name'")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTag ImmutableTag.copyOf(Tag)"})
  void testCopyOf_whenBuilderIdOneNameNameTargetKindAllBuild_thenReturnName() {
    // Arrange
    ImmutableTag instance =
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build();

    // Act
    ImmutableTag actualCopyOfResult = ImmutableTag.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetKind());
    assertTrue(actualCopyOfResult.tagUsages().isEmpty());
  }

  /**
   * Test {@link ImmutableTag#equals(Object)}, and {@link ImmutableTag#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTag#equals(Object)}
   *   <li>{@link ImmutableTag#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableTag.equals(Object)", "int ImmutableTag.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableTag immutableTag =
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build();
    ImmutableTag immutableTag2 =
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build();

    // Act and Assert
    assertEquals(immutableTag, immutableTag2);
    assertEquals(immutableTag.hashCode(), immutableTag2.hashCode());
  }

  /**
   * Test {@link ImmutableTag#equals(Object)}, and {@link ImmutableTag#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTag#equals(Object)}
   *   <li>{@link ImmutableTag#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableTag.equals(Object)", "int ImmutableTag.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableTag immutableTag =
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build();

    // Act and Assert
    assertEquals(immutableTag, immutableTag);
    int expectedHashCodeResult = immutableTag.hashCode();
    assertEquals(expectedHashCodeResult, immutableTag.hashCode());
  }

  /**
   * Test {@link ImmutableTag#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableTag.equals(Object)", "int ImmutableTag.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableTag.builder();

    ImmutableTagUsage.Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    builderResult.addTagUsages(
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build());
    ImmutableTag immutableTag =
        builderResult.id(1L).name("Name").targetKind(EntityKind.ALL).build();

    // Act and Assert
    assertNotEquals(
        immutableTag,
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build());
  }

  /**
   * Test {@link ImmutableTag#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableTag.equals(Object)", "int ImmutableTag.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableTag immutableTag =
        ImmutableTag.builder().id(2L).name("Name").targetKind(EntityKind.ALL).build();

    // Act and Assert
    assertNotEquals(
        immutableTag,
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build());
  }

  /**
   * Test {@link ImmutableTag#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableTag.equals(Object)", "int ImmutableTag.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableTag immutableTag =
        ImmutableTag.builder().id(1L).name("java.lang.Long").targetKind(EntityKind.ALL).build();

    // Act and Assert
    assertNotEquals(
        immutableTag,
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build());
  }

  /**
   * Test {@link ImmutableTag#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableTag.equals(Object)", "int ImmutableTag.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableTag immutableTag =
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ACTOR).build();

    // Act and Assert
    assertNotEquals(
        immutableTag,
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build());
  }

  /**
   * Test {@link ImmutableTag#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableTag.equals(Object)", "int ImmutableTag.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build(), null);
  }

  /**
   * Test {@link ImmutableTag#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableTag.equals(Object)", "int ImmutableTag.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build(),
        "Different type to ImmutableTag");
  }

  /**
   * Test {@link ImmutableTag#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) TagUsages is {@link HashSet#HashSet()}.
   *   <li>Then return tagUsages Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) TagUsages is HashSet(); then return tagUsages Empty")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTag ImmutableTag.fromJson(Json)"})
  void testFromJson_givenHashSet_whenJsonTagUsagesIsHashSet_thenReturnTagUsagesEmpty() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setTargetKind(EntityKind.ALL);
    json.setTagUsages(new HashSet<>());

    // Act
    ImmutableTag actualFromJsonResult = ImmutableTag.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetKind());
    assertTrue(actualFromJsonResult.tagUsages().isEmpty());
  }

  /**
   * Test {@link ImmutableTag#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableTagUsage.Json} (default
   *       constructor).
   *   <li>Then return tagUsages size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return tagUsages size is one")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTag ImmutableTag.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnTagUsagesSizeIsOne() {
    // Arrange
    LinkedHashSet<TagUsage> tagUsages = new LinkedHashSet<>();
    tagUsages.add(new ImmutableTagUsage.Json());

    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setTargetKind(EntityKind.ALL);
    json.setTagUsages(tagUsages);

    // Act
    ImmutableTag actualFromJsonResult = ImmutableTag.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals(1, actualFromJsonResult.tagUsages().size());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetKind());
  }

  /**
   * Test {@link ImmutableTag#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) TagUsages is {@code null}.
   *   <li>Then return tagUsages Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) TagUsages is 'null'; then return tagUsages Empty")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTag ImmutableTag.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonTagUsagesIsNull_thenReturnTagUsagesEmpty() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setTargetKind(EntityKind.ALL);
    json.setTagUsages(null);

    // Act
    ImmutableTag actualFromJsonResult = ImmutableTag.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetKind());
    assertTrue(actualFromJsonResult.tagUsages().isEmpty());
  }

  /**
   * Test {@link ImmutableTag#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return tagUsages is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return tagUsages is LinkedHashSet()")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTag ImmutableTag.fromJson(Json)"})
  void testFromJson_thenReturnTagUsagesIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<TagUsage> tagUsages = new LinkedHashSet<>();

    ImmutableTagUsage.Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    tagUsages.add(
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build());
    tagUsages.add(new ImmutableTagUsage.Json());

    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setTargetKind(EntityKind.ALL);
    json.setTagUsages(tagUsages);

    // Act
    ImmutableTag actualFromJsonResult = ImmutableTag.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetKind());
    assertEquals(tagUsages, actualFromJsonResult.tagUsages());
  }

  /**
   * Test {@link ImmutableTag#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return tagUsages size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Id is 'null'; then return tagUsages size is one")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTag ImmutableTag.fromJson(Json)"})
  void testFromJson_whenJsonIdIsNull_thenReturnTagUsagesSizeIsOne() {
    // Arrange
    LinkedHashSet<TagUsage> tagUsages = new LinkedHashSet<>();
    tagUsages.add(new ImmutableTagUsage.Json());

    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setTargetKind(EntityKind.ALL);
    json.setTagUsages(tagUsages);

    // Act
    ImmutableTag actualFromJsonResult = ImmutableTag.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals(1, actualFromJsonResult.tagUsages().size());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetKind());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTag#name()}
   *   <li>{@link ImmutableTag#tagUsages()}
   *   <li>{@link ImmutableTag#targetKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableTag.name()",
    "Set ImmutableTag.tagUsages()",
    "EntityKind ImmutableTag.targetKind()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableTag immutableTag =
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build();

    // Act
    String actualNameResult = immutableTag.name();
    Set<TagUsage> actualTagUsagesResult = immutableTag.tagUsages();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals(EntityKind.ALL, immutableTag.targetKind());
    assertTrue(actualTagUsagesResult.isEmpty());
  }

  /**
   * Test {@link ImmutableTag#id()}.
   *
   * <p>Method under test: {@link ImmutableTag#id()}
   */
  @Test
  @DisplayName("Test id()")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableTag.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build().id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.name);
    assertNull(actualJson.targetKind);
    assertFalse(actualJson.id.isPresent());
    assertTrue(actualJson.tagUsages.isEmpty());
  }

  /**
   * Test Json {@link Json#tagUsages()}.
   *
   * <p>Method under test: {@link Json#tagUsages()}
   */
  @Test
  @DisplayName("Test Json tagUsages()")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.tagUsages()"})
  void testJsonTagUsages() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().tagUsages());
  }

  /**
   * Test Json {@link Json#targetKind()}.
   *
   * <p>Method under test: {@link Json#targetKind()}
   */
  @Test
  @DisplayName("Test Json targetKind()")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.targetKind()"})
  void testJsonTargetKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetKind());
  }

  /**
   * Test {@link ImmutableTag#toString()}.
   *
   * <p>Method under test: {@link ImmutableTag#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableTag.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "Tag{id=1, name=Name, targetKind=ALL, tagUsages=[]}",
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build().toString());
  }

  /**
   * Test {@link ImmutableTag#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return builder id one name {@code Name} targetKind {@code ALL} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return builder id one name 'Name' targetKind 'ALL' build")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTag ImmutableTag.withId(Optional)"})
  void testWithIdWithOptional_thenReturnBuilderIdOneNameNameTargetKindAllBuild() {
    // Arrange
    ImmutableTag immutableTag =
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableTag actualWithIdResult = immutableTag.withId(optional);

    // Assert
    assertSame(immutableTag, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableTag#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; when of forty-two; then return 'Name'")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTag ImmutableTag.withId(Optional)"})
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnName() {
    // Arrange
    ImmutableTag immutableTag =
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableTag actualWithIdResult = immutableTag.withId(optional);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals(EntityKind.ALL, actualWithIdResult.targetKind());
    assertTrue(actualWithIdResult.tagUsages().isEmpty());
  }

  /**
   * Test {@link ImmutableTag#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Name'")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTag ImmutableTag.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange and Act
    ImmutableTag actualWithIdResult =
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build().withId(42L);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals(EntityKind.ALL, actualWithIdResult.targetKind());
    assertTrue(actualWithIdResult.tagUsages().isEmpty());
  }

  /**
   * Test {@link ImmutableTag#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder id one name {@code Name} targetKind {@code ALL} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when one; then return builder id one name 'Name' targetKind 'ALL' build")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTag ImmutableTag.withId(long)"})
  void testWithIdWithValue_whenOne_thenReturnBuilderIdOneNameNameTargetKindAllBuild() {
    // Arrange
    ImmutableTag immutableTag =
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build();

    // Act
    ImmutableTag actualWithIdResult = immutableTag.withId(1L);

    // Assert
    assertSame(immutableTag, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableTag#withName(String)}.
   *
   * <ul>
   *   <li>Given builder id one name {@code Name} targetKind {@code ALL} build.
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#withName(String)}
   */
  @Test
  @DisplayName(
      "Test withName(String); given builder id one name 'Name' targetKind 'ALL' build; then return name is '42'")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTag ImmutableTag.withName(String)"})
  void testWithName_givenBuilderIdOneNameNameTargetKindAllBuild_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableTag actualWithNameResult =
        ImmutableTag.builder()
            .id(1L)
            .name("Name")
            .targetKind(EntityKind.ALL)
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals(EntityKind.ALL, actualWithNameResult.targetKind());
    assertTrue(actualWithNameResult.tagUsages().isEmpty());
  }

  /**
   * Test {@link ImmutableTag#withName(String)}.
   *
   * <ul>
   *   <li>Then return builder id one name {@code 42} targetKind {@code ALL} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return builder id one name '42' targetKind 'ALL' build")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTag ImmutableTag.withName(String)"})
  void testWithName_thenReturnBuilderIdOneName42TargetKindAllBuild() {
    // Arrange
    ImmutableTag immutableTag =
        ImmutableTag.builder().id(1L).name("42").targetKind(EntityKind.ALL).build();

    // Act
    ImmutableTag actualWithNameResult = immutableTag.withName("42");

    // Assert
    assertSame(immutableTag, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableTag#withTagUsages(TagUsage[])} with {@code TagUsage[]}.
   *
   * <p>Method under test: {@link ImmutableTag#withTagUsages(TagUsage[])}
   */
  @Test
  @DisplayName("Test withTagUsages(TagUsage[]) with 'TagUsage[]'")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTag ImmutableTag.withTagUsages(TagUsage[])"})
  void testWithTagUsagesWithTagUsage() {
    // Arrange
    ImmutableTag immutableTag =
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build();

    ImmutableTagUsage.Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Act
    ImmutableTag actualWithTagUsagesResult =
        immutableTag.withTagUsages(
            createdByResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .tagId(1L)
                .build());

    // Assert
    assertEquals("Name", actualWithTagUsagesResult.name());
    assertEquals(1, actualWithTagUsagesResult.tagUsages().size());
    assertEquals(EntityKind.ALL, actualWithTagUsagesResult.targetKind());
  }

  /**
   * Test {@link ImmutableTag#withTargetKind(EntityKind)}.
   *
   * <ul>
   *   <li>Given builder id one name {@code Name} targetKind {@code ACTOR} build.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#withTargetKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withTargetKind(EntityKind); given builder id one name 'Name' targetKind 'ACTOR' build; then return 'Name'")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTag ImmutableTag.withTargetKind(EntityKind)"})
  void testWithTargetKind_givenBuilderIdOneNameNameTargetKindActorBuild_thenReturnName() {
    // Arrange and Act
    ImmutableTag actualWithTargetKindResult =
        ImmutableTag.builder()
            .id(1L)
            .name("Name")
            .targetKind(EntityKind.ACTOR)
            .build()
            .withTargetKind(EntityKind.ALL);

    // Assert
    assertEquals("Name", actualWithTargetKindResult.name());
    assertEquals(EntityKind.ALL, actualWithTargetKindResult.targetKind());
    assertTrue(actualWithTargetKindResult.tagUsages().isEmpty());
  }

  /**
   * Test {@link ImmutableTag#withTargetKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return builder id one name {@code Name} targetKind {@code ALL} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTag#withTargetKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withTargetKind(EntityKind); then return builder id one name 'Name' targetKind 'ALL' build")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTag ImmutableTag.withTargetKind(EntityKind)"})
  void testWithTargetKind_thenReturnBuilderIdOneNameNameTargetKindAllBuild() {
    // Arrange
    ImmutableTag immutableTag =
        ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build();

    // Act
    ImmutableTag actualWithTargetKindResult = immutableTag.withTargetKind(EntityKind.ALL);

    // Assert
    assertSame(immutableTag, actualWithTargetKindResult);
  }
}
