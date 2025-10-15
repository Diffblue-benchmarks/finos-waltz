package org.finos.waltz.model.custom_environment;

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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.custom_environment.ImmutableCustomEnvironment.Builder;
import org.finos.waltz.model.custom_environment.ImmutableCustomEnvironment.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCustomEnvironmentDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#groupName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironment Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.groupName(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDescriptionResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something");
    Optional<String> description = Optional.of("foo");
    Builder actualExternalIdResult =
        actualDescriptionResult.description(description).externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult =
        actualExternalIdResult.externalId(externalId).groupName("Group Name").id(1L);
    Optional<Long> id = Optional.of(1L);
    Builder actualNameResult = actualIdResult.id(id).name("Name");
    ImmutableEntityReference owningEntity =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableCustomEnvironment actualImmutableCustomEnvironment =
        actualNameResult.owningEntity(owningEntity).build();

    // Assert
    assertEquals("Group Name", actualImmutableCustomEnvironment.groupName());
    assertEquals("Name", actualImmutableCustomEnvironment.name());
    assertSame(owningEntity, actualImmutableCustomEnvironment.owningEntity());
  }

  /**
   * Test Builder {@link Builder#description(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#description(Optional)}
   */
  @Test
  @DisplayName("Test Builder description(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.description(Optional)"})
  void testBuilderDescriptionWithOptional() {
    // Arrange
    Builder builderResult = ImmutableCustomEnvironment.builder();
    Optional<String> description = Optional.of("foo");

    // Act
    Builder actualDescriptionResult = builderResult.description(description);

    // Assert
    assertSame(builderResult, actualDescriptionResult);
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableCustomEnvironment.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(CustomEnvironment)} with {@code CustomEnvironment}.
   *
   * <p>Method under test: {@link Builder#from(CustomEnvironment)}
   */
  @Test
  @DisplayName("Test Builder from(CustomEnvironment) with 'CustomEnvironment'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CustomEnvironment)"})
  void testBuilderFromWithCustomEnvironment() {
    // Arrange
    Builder builderResult = ImmutableCustomEnvironment.builder();

    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment instance =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCustomEnvironment actualImmutableCustomEnvironment = builderResult.build();
    assertEquals(instance, actualImmutableCustomEnvironment);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableCustomEnvironment.builder();

    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment instance =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutableCustomEnvironment actualImmutableCustomEnvironment =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableCustomEnvironment);
    ImmutableCustomEnvironment actualImmutableCustomEnvironment2 = builderResult.build();
    assertEquals(instance, actualImmutableCustomEnvironment2);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableCustomEnvironment.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given of {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given of 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOfFoo() {
    // Arrange
    Builder builderResult = ImmutableCustomEnvironment.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCustomEnvironment.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
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
    Builder builderResult = ImmutableCustomEnvironment.builder();

    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment instance =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutableCustomEnvironment actualImmutableCustomEnvironment =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableCustomEnvironment);
    ImmutableCustomEnvironment actualImmutableCustomEnvironment2 = builderResult.build();
    assertEquals(instance, actualImmutableCustomEnvironment2);
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
    Builder builderResult = ImmutableCustomEnvironment.builder();

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
   *   <li>Given of one.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne() {
    // Arrange
    Builder builderResult = ImmutableCustomEnvironment.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCustomEnvironment.builder();

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableCustomEnvironment.builder();

    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment instance =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutableCustomEnvironment actualImmutableCustomEnvironment =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableCustomEnvironment);
    ImmutableCustomEnvironment actualImmutableCustomEnvironment2 = builderResult.build();
    assertEquals(instance, actualImmutableCustomEnvironment2);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCustomEnvironment.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
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
    Builder builderResult = ImmutableCustomEnvironment.builder();

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
    Builder builderResult = ImmutableCustomEnvironment.builder();
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
    Builder builderResult = ImmutableCustomEnvironment.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#owningEntity(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#owningEntity(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder owningEntity(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.owningEntity(EntityReference)"})
  void testBuilderOwningEntity_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCustomEnvironment.builder();

    // Act
    Builder actualOwningEntityResult = builderResult.owningEntity(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualOwningEntityResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironment#copyOf(CustomEnvironment)}.
   *
   * <ul>
   *   <li>Then owningEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#copyOf(CustomEnvironment)}
   */
  @Test
  @DisplayName("Test copyOf(CustomEnvironment); then owningEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironment ImmutableCustomEnvironment.copyOf(CustomEnvironment)"
  })
  void testCopyOf_thenOwningEntityReturnImmutableEntityReference() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment instance =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableCustomEnvironment actualCopyOfResult = ImmutableCustomEnvironment.copyOf(instance);

    // Assert
    EntityReference owningEntityResult = actualCopyOfResult.owningEntity();
    assertTrue(owningEntityResult instanceof ImmutableEntityReference);
    assertEquals("Group Name", actualCopyOfResult.groupName());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", owningEntityResult.description());
    assertEquals(1L, owningEntityResult.id());
    assertEquals(EntityKind.ALL, owningEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, owningEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#description()}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#description()}
   */
  @Test
  @DisplayName("Test description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableCustomEnvironment.description()"})
  void testDescription() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act
    Optional<String> actualDescriptionResult =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .description();

    // Assert
    assertEquals("The characteristics of someone or something", actualDescriptionResult.get());
    assertTrue(actualDescriptionResult.isPresent());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#equals(Object)}, and {@link
   * ImmutableCustomEnvironment#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCustomEnvironment#equals(Object)}
   *   <li>{@link ImmutableCustomEnvironment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironment.equals(Object)",
    "int ImmutableCustomEnvironment.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder nameResult2 =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment2 =
        nameResult2
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableCustomEnvironment, immutableCustomEnvironment2);
    assertEquals(immutableCustomEnvironment.hashCode(), immutableCustomEnvironment2.hashCode());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#equals(Object)}, and {@link
   * ImmutableCustomEnvironment#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCustomEnvironment#equals(Object)}
   *   <li>{@link ImmutableCustomEnvironment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironment.equals(Object)",
    "int ImmutableCustomEnvironment.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableCustomEnvironment, immutableCustomEnvironment);
    int expectedHashCodeResult = immutableCustomEnvironment.hashCode();
    assertEquals(expectedHashCodeResult, immutableCustomEnvironment.hashCode());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironment.equals(Object)",
    "int ImmutableCustomEnvironment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("Name")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder nameResult2 =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableCustomEnvironment,
        nameResult2
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironment.equals(Object)",
    "int ImmutableCustomEnvironment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("Name")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder nameResult2 =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableCustomEnvironment,
        nameResult2
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironment.equals(Object)",
    "int ImmutableCustomEnvironment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder nameResult2 =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableCustomEnvironment,
        nameResult2
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironment.equals(Object)",
    "int ImmutableCustomEnvironment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(2L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder nameResult2 =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableCustomEnvironment,
        nameResult2
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironment.equals(Object)",
    "int ImmutableCustomEnvironment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Group Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder nameResult2 =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableCustomEnvironment,
        nameResult2
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironment.equals(Object)",
    "int ImmutableCustomEnvironment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder nameResult2 =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableCustomEnvironment,
        nameResult2
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironment.equals(Object)",
    "int ImmutableCustomEnvironment.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableCustomEnvironment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironment.equals(Object)",
    "int ImmutableCustomEnvironment.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableCustomEnvironment");
  }

  /**
   * Test {@link ImmutableCustomEnvironment#externalId()}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableCustomEnvironment.externalId()"})
  void testExternalId() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act
    Optional<String> actualExternalIdResult =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code foo}.
   *   <li>When {@link Json} (default constructor) Description is of {@code foo}.
   *   <li>Then return groupName is {@code Default}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of 'foo'; when Json (default constructor) Description is of 'foo'; then return groupName is 'Default'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCustomEnvironment ImmutableCustomEnvironment.fromJson(Json)"})
  void testFromJson_givenOfFoo_whenJsonDescriptionIsOfFoo_thenReturnGroupNameIsDefault() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setExternalId(null);
    json.setOwningEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    Optional<String> description = Optional.of("foo");
    json.setDescription(description);
    json.setGroupName(null);

    // Act
    ImmutableCustomEnvironment actualFromJsonResult = ImmutableCustomEnvironment.fromJson(json);

    // Assert
    assertEquals("Default", actualFromJsonResult.groupName());
    assertEquals("Json", actualFromJsonResult.name());
    EntityReference expectedOwningEntityResult = json.owningEntity;
    assertSame(expectedOwningEntityResult, actualFromJsonResult.owningEntity());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code foo}.
   *   <li>When {@link Json} (default constructor) ExternalId is of {@code foo}.
   *   <li>Then return groupName is {@code Default}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of 'foo'; when Json (default constructor) ExternalId is of 'foo'; then return groupName is 'Default'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCustomEnvironment ImmutableCustomEnvironment.fromJson(Json)"})
  void testFromJson_givenOfFoo_whenJsonExternalIdIsOfFoo_thenReturnGroupNameIsDefault() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    Optional<String> externalId = Optional.of("foo");
    json.setExternalId(externalId);
    json.setOwningEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setDescription(null);
    json.setGroupName(null);

    // Act
    ImmutableCustomEnvironment actualFromJsonResult = ImmutableCustomEnvironment.fromJson(json);

    // Assert
    assertEquals("Default", actualFromJsonResult.groupName());
    assertEquals("Json", actualFromJsonResult.name());
    EntityReference expectedOwningEntityResult = json.owningEntity;
    assertSame(expectedOwningEntityResult, actualFromJsonResult.owningEntity());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of three.
   *   <li>When {@link Json} (default constructor) Id is of three.
   *   <li>Then return groupName is {@code Default}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of three; when Json (default constructor) Id is of three; then return groupName is 'Default'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCustomEnvironment ImmutableCustomEnvironment.fromJson(Json)"})
  void testFromJson_givenOfThree_whenJsonIdIsOfThree_thenReturnGroupNameIsDefault() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(3L);
    json.setId(id);
    json.setName("Json");
    json.setExternalId(null);
    json.setOwningEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setDescription(null);
    json.setGroupName(null);

    // Act
    ImmutableCustomEnvironment actualFromJsonResult = ImmutableCustomEnvironment.fromJson(json);

    // Assert
    assertEquals("Default", actualFromJsonResult.groupName());
    assertEquals("Json", actualFromJsonResult.name());
    EntityReference expectedOwningEntityResult = json.owningEntity;
    assertSame(expectedOwningEntityResult, actualFromJsonResult.owningEntity());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return groupName is {@code Default}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return groupName is 'Default'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCustomEnvironment ImmutableCustomEnvironment.fromJson(Json)"})
  void testFromJson_thenReturnGroupNameIsDefault() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setExternalId(null);
    json.setOwningEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setDescription(null);
    json.setGroupName(null);

    // Act
    ImmutableCustomEnvironment actualFromJsonResult = ImmutableCustomEnvironment.fromJson(json);

    // Assert
    assertEquals("Default", actualFromJsonResult.groupName());
    assertEquals("Json", actualFromJsonResult.name());
    EntityReference expectedOwningEntityResult = json.owningEntity;
    assertSame(expectedOwningEntityResult, actualFromJsonResult.owningEntity());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) GroupName is {@code Json}.
   *   <li>Then return groupName is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) GroupName is 'Json'; then return groupName is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCustomEnvironment ImmutableCustomEnvironment.fromJson(Json)"})
  void testFromJson_whenJsonGroupNameIsJson_thenReturnGroupNameIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setExternalId(null);
    json.setOwningEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setDescription(null);
    json.setGroupName("Json");

    // Act
    ImmutableCustomEnvironment actualFromJsonResult = ImmutableCustomEnvironment.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.groupName());
    assertEquals("Json", actualFromJsonResult.name());
    EntityReference expectedOwningEntityResult = json.owningEntity;
    assertSame(expectedOwningEntityResult, actualFromJsonResult.owningEntity());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCustomEnvironment#groupName()}
   *   <li>{@link ImmutableCustomEnvironment#name()}
   *   <li>{@link ImmutableCustomEnvironment#owningEntity()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableCustomEnvironment.groupName()",
    "String ImmutableCustomEnvironment.name()",
    "EntityReference ImmutableCustomEnvironment.owningEntity()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    String actualGroupNameResult = immutableCustomEnvironment.groupName();
    String actualNameResult = immutableCustomEnvironment.name();

    // Assert
    assertTrue(immutableCustomEnvironment.owningEntity() instanceof ImmutableEntityReference);
    assertEquals("Group Name", actualGroupNameResult);
    assertEquals("Name", actualNameResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironment#id()}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableCustomEnvironment.id()"})
  void testId() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act
    Optional<Long> actualIdResult =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
  }

  /**
   * Test Json {@link Json#groupName()}.
   *
   * <p>Method under test: {@link Json#groupName()}
   */
  @Test
  @DisplayName("Test Json groupName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.groupName()"})
  void testJsonGroupName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().groupName());
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
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.groupName);
    assertNull(actualJson.name);
    assertNull(actualJson.owningEntity);
    assertFalse(actualJson.description.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#owningEntity()}.
   *
   * <p>Method under test: {@link Json#owningEntity()}
   */
  @Test
  @DisplayName("Test Json owningEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.owningEntity()"})
  void testJsonOwningEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().owningEntity());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#toString()}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableCustomEnvironment.toString()"})
  void testToString() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act and Assert
    assertEquals(
        "CustomEnvironment{id=1, name=Name, externalId=42, owningEntity=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, description=The characteristics of someone or something, groupName=Group"
            + " Name}",
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#withDescription(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#withDescription(Optional)}
   */
  @Test
  @DisplayName("Test withDescription(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironment ImmutableCustomEnvironment.withDescription(Optional)"
  })
  void testWithDescriptionWithOptional() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableCustomEnvironment actualWithDescriptionResult =
        immutableCustomEnvironment.withDescription(optional);

    // Assert
    EntityReference owningEntityResult = actualWithDescriptionResult.owningEntity();
    assertTrue(owningEntityResult instanceof ImmutableEntityReference);
    assertEquals("Group Name", actualWithDescriptionResult.groupName());
    assertEquals("Name", actualWithDescriptionResult.name());
    assertEquals("The characteristics of someone or something", owningEntityResult.description());
    assertEquals(1L, owningEntityResult.id());
    assertEquals(EntityKind.ALL, owningEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, owningEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#withDescription(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironment ImmutableCustomEnvironment.withDescription(String)"
  })
  void testWithDescriptionWithValue() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("42")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableCustomEnvironment actualWithDescriptionResult =
        immutableCustomEnvironment.withDescription("42");

    // Assert
    assertSame(immutableCustomEnvironment, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironment#withDescription(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then owningEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#withDescription(String)}
   */
  @Test
  @DisplayName(
      "Test withDescription(String) with 'value'; then owningEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironment ImmutableCustomEnvironment.withDescription(String)"
  })
  void testWithDescriptionWithValue_thenOwningEntityReturnImmutableEntityReference() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act
    ImmutableCustomEnvironment actualWithDescriptionResult =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withDescription("42");

    // Assert
    EntityReference owningEntityResult = actualWithDescriptionResult.owningEntity();
    assertTrue(owningEntityResult instanceof ImmutableEntityReference);
    assertEquals("Group Name", actualWithDescriptionResult.groupName());
    assertEquals("Name", actualWithDescriptionResult.name());
    assertEquals("The characteristics of someone or something", owningEntityResult.description());
    assertEquals(1L, owningEntityResult.id());
    assertEquals(EntityKind.ALL, owningEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, owningEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironment ImmutableCustomEnvironment.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableCustomEnvironment actualWithExternalIdResult =
        immutableCustomEnvironment.withExternalId(optional);

    // Assert
    assertSame(immutableCustomEnvironment, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironment#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then owningEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; then owningEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironment ImmutableCustomEnvironment.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_thenOwningEntityReturnImmutableEntityReference() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableCustomEnvironment actualWithExternalIdResult =
        immutableCustomEnvironment.withExternalId(optional);

    // Assert
    EntityReference owningEntityResult = actualWithExternalIdResult.owningEntity();
    assertTrue(owningEntityResult instanceof ImmutableEntityReference);
    assertEquals("Group Name", actualWithExternalIdResult.groupName());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("The characteristics of someone or something", owningEntityResult.description());
    assertEquals(1L, owningEntityResult.id());
    assertEquals(EntityKind.ALL, owningEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, owningEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironment ImmutableCustomEnvironment.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableCustomEnvironment actualWithExternalIdResult =
        immutableCustomEnvironment.withExternalId("42");

    // Assert
    assertSame(immutableCustomEnvironment, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironment#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then owningEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; then owningEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironment ImmutableCustomEnvironment.withExternalId(String)"
  })
  void testWithExternalIdWithValue_thenOwningEntityReturnImmutableEntityReference() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act
    ImmutableCustomEnvironment actualWithExternalIdResult =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    EntityReference owningEntityResult = actualWithExternalIdResult.owningEntity();
    assertTrue(owningEntityResult instanceof ImmutableEntityReference);
    assertEquals("Group Name", actualWithExternalIdResult.groupName());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("The characteristics of someone or something", owningEntityResult.description());
    assertEquals(1L, owningEntityResult.id());
    assertEquals(EntityKind.ALL, owningEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, owningEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#withGroupName(String)}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#withGroupName(String)}
   */
  @Test
  @DisplayName("Test withGroupName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCustomEnvironment ImmutableCustomEnvironment.withGroupName(String)"})
  void testWithGroupName() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("42")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableCustomEnvironment actualWithGroupNameResult =
        immutableCustomEnvironment.withGroupName("42");

    // Assert
    assertSame(immutableCustomEnvironment, actualWithGroupNameResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironment#withGroupName(String)}.
   *
   * <ul>
   *   <li>Then owningEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#withGroupName(String)}
   */
  @Test
  @DisplayName("Test withGroupName(String); then owningEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCustomEnvironment ImmutableCustomEnvironment.withGroupName(String)"})
  void testWithGroupName_thenOwningEntityReturnImmutableEntityReference() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act
    ImmutableCustomEnvironment actualWithGroupNameResult =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withGroupName("42");

    // Assert
    EntityReference owningEntityResult = actualWithGroupNameResult.owningEntity();
    assertTrue(owningEntityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithGroupNameResult.groupName());
    assertEquals("Name", actualWithGroupNameResult.name());
    assertEquals("The characteristics of someone or something", owningEntityResult.description());
    assertEquals(1L, owningEntityResult.id());
    assertEquals(EntityKind.ALL, owningEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, owningEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCustomEnvironment ImmutableCustomEnvironment.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableCustomEnvironment actualWithIdResult = immutableCustomEnvironment.withId(optional);

    // Assert
    assertSame(immutableCustomEnvironment, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironment#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then owningEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then owningEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCustomEnvironment ImmutableCustomEnvironment.withId(Optional)"})
  void testWithIdWithOptional_thenOwningEntityReturnImmutableEntityReference() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(2L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableCustomEnvironment actualWithIdResult = immutableCustomEnvironment.withId(optional);

    // Assert
    EntityReference owningEntityResult = actualWithIdResult.owningEntity();
    assertTrue(owningEntityResult instanceof ImmutableEntityReference);
    assertEquals("Group Name", actualWithIdResult.groupName());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", owningEntityResult.description());
    assertEquals(1L, owningEntityResult.id());
    assertEquals(EntityKind.ALL, owningEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, owningEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCustomEnvironment ImmutableCustomEnvironment.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableCustomEnvironment actualWithIdResult = immutableCustomEnvironment.withId(1L);

    // Assert
    assertSame(immutableCustomEnvironment, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironment#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then owningEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when forty-two; then owningEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCustomEnvironment ImmutableCustomEnvironment.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenOwningEntityReturnImmutableEntityReference() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act
    ImmutableCustomEnvironment actualWithIdResult =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withId(42L);

    // Assert
    EntityReference owningEntityResult = actualWithIdResult.owningEntity();
    assertTrue(owningEntityResult instanceof ImmutableEntityReference);
    assertEquals("Group Name", actualWithIdResult.groupName());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", owningEntityResult.description());
    assertEquals(1L, owningEntityResult.id());
    assertEquals(EntityKind.ALL, owningEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, owningEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCustomEnvironment ImmutableCustomEnvironment.withName(String)"})
  void testWithName() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("42");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableCustomEnvironment actualWithNameResult = immutableCustomEnvironment.withName("42");

    // Assert
    assertSame(immutableCustomEnvironment, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironment#withName(String)}.
   *
   * <ul>
   *   <li>Then owningEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then owningEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCustomEnvironment ImmutableCustomEnvironment.withName(String)"})
  void testWithName_thenOwningEntityReturnImmutableEntityReference() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act
    ImmutableCustomEnvironment actualWithNameResult =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withName("42");

    // Assert
    EntityReference owningEntityResult = actualWithNameResult.owningEntity();
    assertTrue(owningEntityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Group Name", actualWithNameResult.groupName());
    assertEquals("The characteristics of someone or something", owningEntityResult.description());
    assertEquals(1L, owningEntityResult.id());
    assertEquals(EntityKind.ALL, owningEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, owningEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableCustomEnvironment#withOwningEntity(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironment#withOwningEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test withOwningEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironment ImmutableCustomEnvironment.withOwningEntity(EntityReference)"
  })
  void testWithOwningEntity() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    ImmutableCustomEnvironment immutableCustomEnvironment =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableCustomEnvironment actualWithOwningEntityResult =
        immutableCustomEnvironment.withOwningEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableCustomEnvironment, actualWithOwningEntityResult);
  }
}
