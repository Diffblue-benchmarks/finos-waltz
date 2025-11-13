package org.finos.waltz.model.licence;

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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.licence.ImmutableSaveLicenceCommand.Builder;
import org.finos.waltz.model.licence.ImmutableSaveLicenceCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSaveLicenceCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveLicenceCommand Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("42");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutableSaveLicenceCommand actualImmutableSaveLicenceCommand =
        actualIdResult.id(id).name("Name").build();

    // Assert
    assertEquals("Name", actualImmutableSaveLicenceCommand.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableSaveLicenceCommand.description());
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
    Builder builderResult = ImmutableSaveLicenceCommand.builder();
    Optional<String> externalId = Optional.of("42");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableSaveLicenceCommand.builder();
    ImmutableSaveLicenceCommand instance =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableSaveLicenceCommand actualImmutableSaveLicenceCommand = builderResult.build();
    assertEquals(instance, actualImmutableSaveLicenceCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider2() {
    // Arrange
    Builder builderResult = ImmutableSaveLicenceCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableSaveLicenceCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSaveLicenceCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
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
    Builder builderResult = ImmutableSaveLicenceCommand.builder();
    ImmutableSaveLicenceCommand instance =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableSaveLicenceCommand actualImmutableSaveLicenceCommand = builderResult.build();
    assertEquals(instance, actualImmutableSaveLicenceCommand);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableSaveLicenceCommand.builder();

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
   *   <li>Given of {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given of '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOf42() {
    // Arrange
    Builder builderResult = ImmutableSaveLicenceCommand.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("42");
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
    Builder builderResult = ImmutableSaveLicenceCommand.builder();

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
    Builder builderResult = ImmutableSaveLicenceCommand.builder();
    ImmutableSaveLicenceCommand instance =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableSaveLicenceCommand actualImmutableSaveLicenceCommand = builderResult.build();
    assertEquals(instance, actualImmutableSaveLicenceCommand);
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
    Builder builderResult = ImmutableSaveLicenceCommand.builder();

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfFortyTwo_whenIdProviderIdReturnOfFortyTwo() {
    // Arrange
    Builder builderResult = ImmutableSaveLicenceCommand.builder();

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSaveLicenceCommand.builder();

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
    Builder builderResult = ImmutableSaveLicenceCommand.builder();
    ImmutableSaveLicenceCommand instance =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSaveLicenceCommand actualImmutableSaveLicenceCommand = builderResult.build();
    assertEquals(instance, actualImmutableSaveLicenceCommand);
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
  void testBuilderFromWithNameProvider2() {
    // Arrange
    Builder builderResult = ImmutableSaveLicenceCommand.builder();
    ImmutableSaveLicenceCommand instance =
        ImmutableSaveLicenceCommand.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSaveLicenceCommand actualImmutableSaveLicenceCommand = builderResult.build();
    assertEquals(instance, actualImmutableSaveLicenceCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then builder build name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then builder build name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableSaveLicenceCommand.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    ImmutableSaveLicenceCommand immutableSaveLicenceCommand = builderResult.build();
    assertEquals("Name", immutableSaveLicenceCommand.name());
    assertNull(immutableSaveLicenceCommand.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SaveLicenceCommand)} with {@code SaveLicenceCommand}.
   *
   * <p>Method under test: {@link Builder#from(SaveLicenceCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveLicenceCommand) with 'SaveLicenceCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SaveLicenceCommand)"})
  void testBuilderFromWithSaveLicenceCommand() {
    // Arrange
    Builder builderResult = ImmutableSaveLicenceCommand.builder();
    ImmutableSaveLicenceCommand instance =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSaveLicenceCommand actualImmutableSaveLicenceCommand = builderResult.build();
    assertEquals(instance, actualImmutableSaveLicenceCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SaveLicenceCommand)} with {@code SaveLicenceCommand}.
   *
   * <p>Method under test: {@link Builder#from(SaveLicenceCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveLicenceCommand) with 'SaveLicenceCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SaveLicenceCommand)"})
  void testBuilderFromWithSaveLicenceCommand2() {
    // Arrange
    Builder builderResult = ImmutableSaveLicenceCommand.builder();
    ImmutableSaveLicenceCommand instance =
        ImmutableSaveLicenceCommand.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSaveLicenceCommand actualImmutableSaveLicenceCommand = builderResult.build();
    assertEquals(instance, actualImmutableSaveLicenceCommand);
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
    Builder builderResult = ImmutableSaveLicenceCommand.builder();

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
    Builder builderResult = ImmutableSaveLicenceCommand.builder();
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
   *   <li>Then builder build name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then builder build name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableSaveLicenceCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableSaveLicenceCommand immutableSaveLicenceCommand = builderResult.build();
    assertEquals("Name", immutableSaveLicenceCommand.name());
    assertNull(immutableSaveLicenceCommand.description());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#copyOf(SaveLicenceCommand)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#copyOf(SaveLicenceCommand)}
   */
  @Test
  @DisplayName("Test copyOf(SaveLicenceCommand); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveLicenceCommand ImmutableSaveLicenceCommand.copyOf(SaveLicenceCommand)"
  })
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableSaveLicenceCommand instance =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableSaveLicenceCommand actualCopyOfResult = ImmutableSaveLicenceCommand.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#equals(Object)}, and {@link
   * ImmutableSaveLicenceCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSaveLicenceCommand#equals(Object)}
   *   <li>{@link ImmutableSaveLicenceCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveLicenceCommand.equals(Object)",
    "int ImmutableSaveLicenceCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSaveLicenceCommand immutableSaveLicenceCommand =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();
    ImmutableSaveLicenceCommand immutableSaveLicenceCommand2 =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableSaveLicenceCommand, immutableSaveLicenceCommand2);
    assertEquals(immutableSaveLicenceCommand.hashCode(), immutableSaveLicenceCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#equals(Object)}, and {@link
   * ImmutableSaveLicenceCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSaveLicenceCommand#equals(Object)}
   *   <li>{@link ImmutableSaveLicenceCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveLicenceCommand.equals(Object)",
    "int ImmutableSaveLicenceCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSaveLicenceCommand immutableSaveLicenceCommand =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableSaveLicenceCommand, immutableSaveLicenceCommand);
    int expectedHashCodeResult = immutableSaveLicenceCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableSaveLicenceCommand.hashCode());
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveLicenceCommand.equals(Object)",
    "int ImmutableSaveLicenceCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSaveLicenceCommand immutableSaveLicenceCommand =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("Name")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSaveLicenceCommand,
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveLicenceCommand.equals(Object)",
    "int ImmutableSaveLicenceCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSaveLicenceCommand immutableSaveLicenceCommand =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSaveLicenceCommand,
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveLicenceCommand.equals(Object)",
    "int ImmutableSaveLicenceCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableSaveLicenceCommand immutableSaveLicenceCommand =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("externalId")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSaveLicenceCommand,
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveLicenceCommand.equals(Object)",
    "int ImmutableSaveLicenceCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveLicenceCommand.equals(Object)",
    "int ImmutableSaveLicenceCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build(),
        "Different type to ImmutableSaveLicenceCommand");
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#externalId()}.
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSaveLicenceCommand.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Id is 'null'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveLicenceCommand ImmutableSaveLicenceCommand.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonIdIsNull_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);

    // Act
    ImmutableSaveLicenceCommand actualFromJsonResult = ImmutableSaveLicenceCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link Json} (default constructor) Id is of forty-two.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; when Json (default constructor) Id is of forty-two; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveLicenceCommand ImmutableSaveLicenceCommand.fromJson(Json)"})
  void testFromJson_givenOfFortyTwo_whenJsonIdIsOfFortyTwo_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);

    // Act
    ImmutableSaveLicenceCommand actualFromJsonResult = ImmutableSaveLicenceCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Description is {@code null}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Description is 'null'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveLicenceCommand ImmutableSaveLicenceCommand.fromJson(Json)"})
  void testFromJson_whenJsonDescriptionIsNull_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription(null);
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);

    // Act
    ImmutableSaveLicenceCommand actualFromJsonResult = ImmutableSaveLicenceCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) ExternalId is {@code null}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) ExternalId is 'null'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveLicenceCommand ImmutableSaveLicenceCommand.fromJson(Json)"})
  void testFromJson_whenJsonExternalIdIsNull_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");
    json.setExternalId(null);

    // Act
    ImmutableSaveLicenceCommand actualFromJsonResult = ImmutableSaveLicenceCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSaveLicenceCommand#description()}
   *   <li>{@link ImmutableSaveLicenceCommand#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSaveLicenceCommand.description()",
    "String ImmutableSaveLicenceCommand.name()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSaveLicenceCommand immutableSaveLicenceCommand =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    String actualDescriptionResult = immutableSaveLicenceCommand.description();

    // Assert
    assertEquals("Name", immutableSaveLicenceCommand.name());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#id()}.
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSaveLicenceCommand.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
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
  @MethodsUnderTest({"String Json.description()"})
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
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSaveLicenceCommand.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "SaveLicenceCommand{id=1, name=Name, externalId=42}",
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveLicenceCommand ImmutableSaveLicenceCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableSaveLicenceCommand immutableSaveLicenceCommand =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableSaveLicenceCommand actualWithDescriptionResult =
        immutableSaveLicenceCommand.withDescription("42");

    // Assert
    assertEquals(immutableSaveLicenceCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return builder description {@code 42} externalId {@code 42} id one name {@code Name}
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#withDescription(String)}
   */
  @Test
  @DisplayName(
      "Test withDescription(String); then return builder description '42' externalId '42' id one name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveLicenceCommand ImmutableSaveLicenceCommand.withDescription(String)"
  })
  void testWithDescription_thenReturnBuilderDescription42ExternalId42IdOneNameNameBuild() {
    // Arrange
    ImmutableSaveLicenceCommand immutableSaveLicenceCommand =
        ImmutableSaveLicenceCommand.builder()
            .description("42")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableSaveLicenceCommand actualWithDescriptionResult =
        immutableSaveLicenceCommand.withDescription("42");

    // Assert
    assertSame(immutableSaveLicenceCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveLicenceCommand ImmutableSaveLicenceCommand.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableSaveLicenceCommand immutableSaveLicenceCommand =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSaveLicenceCommand actualWithExternalIdResult =
        immutableSaveLicenceCommand.withExternalId(optional);

    // Assert
    assertSame(immutableSaveLicenceCommand, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveLicenceCommand ImmutableSaveLicenceCommand.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_thenReturnName() {
    // Arrange
    ImmutableSaveLicenceCommand immutableSaveLicenceCommand =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("External Id")
            .id(1L)
            .name("Name")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSaveLicenceCommand actualWithExternalIdResult =
        immutableSaveLicenceCommand.withExternalId(optional);

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveLicenceCommand ImmutableSaveLicenceCommand.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableSaveLicenceCommand immutableSaveLicenceCommand =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableSaveLicenceCommand actualWithExternalIdResult =
        immutableSaveLicenceCommand.withExternalId("42");

    // Assert
    assertSame(immutableSaveLicenceCommand, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveLicenceCommand ImmutableSaveLicenceCommand.withExternalId(String)"
  })
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnName() {
    // Arrange and Act
    ImmutableSaveLicenceCommand actualWithExternalIdResult =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveLicenceCommand ImmutableSaveLicenceCommand.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableSaveLicenceCommand immutableSaveLicenceCommand =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSaveLicenceCommand actualWithIdResult = immutableSaveLicenceCommand.withId(optional);

    // Assert
    assertSame(immutableSaveLicenceCommand, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; when of forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveLicenceCommand ImmutableSaveLicenceCommand.withId(Optional)"})
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnName() {
    // Arrange
    ImmutableSaveLicenceCommand immutableSaveLicenceCommand =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableSaveLicenceCommand actualWithIdResult = immutableSaveLicenceCommand.withId(optional);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveLicenceCommand ImmutableSaveLicenceCommand.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableSaveLicenceCommand immutableSaveLicenceCommand =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableSaveLicenceCommand actualWithIdResult = immutableSaveLicenceCommand.withId(1L);

    // Assert
    assertSame(immutableSaveLicenceCommand, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveLicenceCommand ImmutableSaveLicenceCommand.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange and Act
    ImmutableSaveLicenceCommand actualWithIdResult =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build()
            .withId(42L);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveLicenceCommand ImmutableSaveLicenceCommand.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableSaveLicenceCommand immutableSaveLicenceCommand =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("42")
            .build();

    // Act
    ImmutableSaveLicenceCommand actualWithNameResult = immutableSaveLicenceCommand.withName("42");

    // Assert
    assertSame(immutableSaveLicenceCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableSaveLicenceCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveLicenceCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSaveLicenceCommand ImmutableSaveLicenceCommand.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableSaveLicenceCommand actualWithNameResult =
        ImmutableSaveLicenceCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
  }
}
