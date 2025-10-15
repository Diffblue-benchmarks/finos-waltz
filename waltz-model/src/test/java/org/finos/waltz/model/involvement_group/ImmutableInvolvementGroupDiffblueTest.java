package org.finos.waltz.model.involvement_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.involvement_group.ImmutableInvolvementGroup.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementGroupDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementGroup Builder.build()",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult = ImmutableInvolvementGroup.builder().externalId("42").id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableInvolvementGroup actualImmutableInvolvementGroup =
        actualIdResult.id(id).name("Name").provenance("Provenance").build();

    // Assert
    assertEquals("42", actualImmutableInvolvementGroup.externalId());
    assertEquals("Name", actualImmutableInvolvementGroup.name());
    assertEquals("Provenance", actualImmutableInvolvementGroup.provenance());
  }

  /**
   * Test Builder {@link Builder#externalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#externalId(String)}
   */
  @Test
  @DisplayName("Test Builder externalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(String)"})
  void testBuilderExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroup.builder();

    // Act
    Builder actualExternalIdResult = builderResult.externalId("42");

    // Assert
    assertSame(builderResult, actualExternalIdResult);
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
    Builder builderResult = ImmutableInvolvementGroup.builder();
    ImmutableInvolvementGroup instance =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableInvolvementGroup actualImmutableInvolvementGroup = builderResult.build();
    assertEquals(instance, actualImmutableInvolvementGroup);
    assertSame(builderResult, actualFromResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroup.builder();

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
    Builder builderResult = ImmutableInvolvementGroup.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(InvolvementGroup)} with {@code InvolvementGroup}.
   *
   * <p>Method under test: {@link Builder#from(InvolvementGroup)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementGroup) with 'InvolvementGroup'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(InvolvementGroup)"})
  void testBuilderFromWithInvolvementGroup() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroup.builder();
    ImmutableInvolvementGroup instance =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableInvolvementGroup actualImmutableInvolvementGroup = builderResult.build();
    assertEquals(instance, actualImmutableInvolvementGroup);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroup.builder();
    ImmutableInvolvementGroup instance =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableInvolvementGroup actualImmutableInvolvementGroup = builderResult.build();
    assertEquals(instance, actualImmutableInvolvementGroup);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link NameProvider} {@link NameProvider#name()} return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; when NameProvider name() return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_whenNameProviderNameReturnName() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroup.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroup.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroup.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableActor.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isExternal(true)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider2() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroup.builder();
    ImmutableInvolvementGroup instance =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableInvolvementGroup actualImmutableInvolvementGroup = builderResult.build();
    assertEquals(instance, actualImmutableInvolvementGroup);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableInvolvementGroup.builder();

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
    Builder builderResult = ImmutableInvolvementGroup.builder();
    Optional<Long> id = Optional.of(1L);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroup.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableInvolvementGroup#copyOf(InvolvementGroup)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#copyOf(InvolvementGroup)}
   */
  @Test
  @DisplayName("Test copyOf(InvolvementGroup); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementGroup ImmutableInvolvementGroup.copyOf(InvolvementGroup)"
  })
  void testCopyOf_thenReturnExternalIdIs42() {
    // Arrange
    ImmutableInvolvementGroup instance =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableInvolvementGroup actualCopyOfResult = ImmutableInvolvementGroup.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
  }

  /**
   * Test {@link ImmutableInvolvementGroup#equals(Object)}, and {@link
   * ImmutableInvolvementGroup#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementGroup#equals(Object)}
   *   <li>{@link ImmutableInvolvementGroup#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementGroup.equals(Object)",
    "int ImmutableInvolvementGroup.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableInvolvementGroup immutableInvolvementGroup =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build();
    ImmutableInvolvementGroup immutableInvolvementGroup2 =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableInvolvementGroup, immutableInvolvementGroup2);
    assertEquals(immutableInvolvementGroup.hashCode(), immutableInvolvementGroup2.hashCode());
  }

  /**
   * Test {@link ImmutableInvolvementGroup#equals(Object)}, and {@link
   * ImmutableInvolvementGroup#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementGroup#equals(Object)}
   *   <li>{@link ImmutableInvolvementGroup#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementGroup.equals(Object)",
    "int ImmutableInvolvementGroup.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableInvolvementGroup immutableInvolvementGroup =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableInvolvementGroup, immutableInvolvementGroup);
    int expectedHashCodeResult = immutableInvolvementGroup.hashCode();
    assertEquals(expectedHashCodeResult, immutableInvolvementGroup.hashCode());
  }

  /**
   * Test {@link ImmutableInvolvementGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementGroup.equals(Object)",
    "int ImmutableInvolvementGroup.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableInvolvementGroup immutableInvolvementGroup =
        ImmutableInvolvementGroup.builder()
            .externalId("Name")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableInvolvementGroup,
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableInvolvementGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementGroup.equals(Object)",
    "int ImmutableInvolvementGroup.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableInvolvementGroup immutableInvolvementGroup =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(2L)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableInvolvementGroup,
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableInvolvementGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementGroup.equals(Object)",
    "int ImmutableInvolvementGroup.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableInvolvementGroup immutableInvolvementGroup =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Provenance")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableInvolvementGroup,
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableInvolvementGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementGroup.equals(Object)",
    "int ImmutableInvolvementGroup.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableInvolvementGroup immutableInvolvementGroup =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableInvolvementGroup,
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableInvolvementGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementGroup.equals(Object)",
    "int ImmutableInvolvementGroup.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableInvolvementGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementGroup.equals(Object)",
    "int ImmutableInvolvementGroup.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build(),
        "Different type to ImmutableInvolvementGroup");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementGroup#externalId()}
   *   <li>{@link ImmutableInvolvementGroup#name()}
   *   <li>{@link ImmutableInvolvementGroup#provenance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableInvolvementGroup.externalId()",
    "String ImmutableInvolvementGroup.name()",
    "String ImmutableInvolvementGroup.provenance()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableInvolvementGroup immutableInvolvementGroup =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    String actualExternalIdResult = immutableInvolvementGroup.externalId();
    String actualNameResult = immutableInvolvementGroup.name();

    // Assert
    assertEquals("42", actualExternalIdResult);
    assertEquals("Name", actualNameResult);
    assertEquals("Provenance", immutableInvolvementGroup.provenance());
  }

  /**
   * Test {@link ImmutableInvolvementGroup#id()}.
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableInvolvementGroup.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableInvolvementGroup#toString()}.
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableInvolvementGroup.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "InvolvementGroup{id=1, name=Name, provenance=Provenance, externalId=42}",
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableInvolvementGroup#withExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementGroup ImmutableInvolvementGroup.withExternalId(String)"})
  void testWithExternalId() {
    // Arrange
    ImmutableInvolvementGroup immutableInvolvementGroup =
        ImmutableInvolvementGroup.builder()
            .externalId("0123456789ABCDEF")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableInvolvementGroup actualWithExternalIdResult =
        immutableInvolvementGroup.withExternalId("0123456789ABCDEF");

    // Assert
    assertSame(immutableInvolvementGroup, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableInvolvementGroup#withExternalId(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String); then return externalId is '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementGroup ImmutableInvolvementGroup.withExternalId(String)"})
  void testWithExternalId_thenReturnExternalIdIs0123456789abcdef() {
    // Arrange and Act
    ImmutableInvolvementGroup actualWithExternalIdResult =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", actualWithExternalIdResult.externalId());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
  }

  /**
   * Test {@link ImmutableInvolvementGroup#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementGroup ImmutableInvolvementGroup.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableInvolvementGroup immutableInvolvementGroup =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableInvolvementGroup actualWithIdResult = immutableInvolvementGroup.withId(optional);

    // Assert
    assertSame(immutableInvolvementGroup, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableInvolvementGroup#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementGroup ImmutableInvolvementGroup.withId(Optional)"})
  void testWithIdWithOptional_thenReturnExternalIdIs42() {
    // Arrange
    ImmutableInvolvementGroup immutableInvolvementGroup =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(2L)
            .name("Name")
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableInvolvementGroup actualWithIdResult = immutableInvolvementGroup.withId(optional);

    // Assert
    assertEquals("42", actualWithIdResult.externalId());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
  }

  /**
   * Test {@link ImmutableInvolvementGroup#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementGroup ImmutableInvolvementGroup.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableInvolvementGroup immutableInvolvementGroup =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableInvolvementGroup actualWithIdResult = immutableInvolvementGroup.withId(1L);

    // Assert
    assertSame(immutableInvolvementGroup, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableInvolvementGroup#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementGroup ImmutableInvolvementGroup.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableInvolvementGroup actualWithIdResult =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build()
            .withId(42L);

    // Assert
    assertEquals("42", actualWithIdResult.externalId());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
  }

  /**
   * Test {@link ImmutableInvolvementGroup#withName(String)}.
   *
   * <ul>
   *   <li>Then return builder externalId {@code 42} id one name {@code 42} provenance {@code
   *       Provenance} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#withName(String)}
   */
  @Test
  @DisplayName(
      "Test withName(String); then return builder externalId '42' id one name '42' provenance 'Provenance' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementGroup ImmutableInvolvementGroup.withName(String)"})
  void testWithName_thenReturnBuilderExternalId42IdOneName42ProvenanceProvenanceBuild() {
    // Arrange
    ImmutableInvolvementGroup immutableInvolvementGroup =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("42")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableInvolvementGroup actualWithNameResult = immutableInvolvementGroup.withName("42");

    // Assert
    assertSame(immutableInvolvementGroup, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableInvolvementGroup#withName(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementGroup ImmutableInvolvementGroup.withName(String)"})
  void testWithName_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableInvolvementGroup actualWithNameResult =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.externalId());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Provenance", actualWithNameResult.provenance());
  }

  /**
   * Test {@link ImmutableInvolvementGroup#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return builder externalId {@code 42} id one name {@code Name} provenance {@code 42}
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#withProvenance(String)}
   */
  @Test
  @DisplayName(
      "Test withProvenance(String); then return builder externalId '42' id one name 'Name' provenance '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementGroup ImmutableInvolvementGroup.withProvenance(String)"})
  void testWithProvenance_thenReturnBuilderExternalId42IdOneNameNameProvenance42Build() {
    // Arrange
    ImmutableInvolvementGroup immutableInvolvementGroup =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("42")
            .build();

    // Act
    ImmutableInvolvementGroup actualWithProvenanceResult =
        immutableInvolvementGroup.withProvenance("42");

    // Assert
    assertSame(immutableInvolvementGroup, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableInvolvementGroup#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementGroup#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementGroup ImmutableInvolvementGroup.withProvenance(String)"})
  void testWithProvenance_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableInvolvementGroup actualWithProvenanceResult =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("42", actualWithProvenanceResult.externalId());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Name", actualWithProvenanceResult.name());
  }
}
