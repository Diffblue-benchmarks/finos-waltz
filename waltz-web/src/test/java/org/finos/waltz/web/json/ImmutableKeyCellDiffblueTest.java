package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.web.json.ImmutableKeyCell.Builder;
import org.finos.waltz.web.json.ImmutableKeyCell.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableKeyCellDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#name(String)}
   *   <li>{@link Builder#type(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableKeyCell Builder.build()",
    "Builder Builder.externalId(String)",
    "Builder Builder.name(String)",
    "Builder Builder.type(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult = ImmutableKeyCell.builder().externalId("42");
    Optional<String> externalId = Optional.of("42");
    Builder actualNameResult =
        actualExternalIdResult
            .externalId(externalId)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name");
    Optional<String> name = Optional.of("42");
    Builder actualWaltzIdResult = actualNameResult.name(name).type("Type").waltzId(1L);
    Optional<Long> waltzId = Optional.of(42L);
    ImmutableKeyCell actualImmutableKeyCell = actualWaltzIdResult.waltzId(waltzId).build();

    // Assert
    assertEquals("Type", actualImmutableKeyCell.type());
    assertEquals(EntityKind.ALL, actualImmutableKeyCell.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualImmutableKeyCell.lifecyclePhase());
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
    Builder builderResult = ImmutableKeyCell.builder();
    Optional<String> externalId = Optional.of("42");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(KeyCell)}.
   *
   * <p>Method under test: {@link Builder#from(KeyCell)}
   */
  @Test
  @DisplayName("Test Builder from(KeyCell)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(KeyCell)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableKeyCell.builder();
    ImmutableKeyCell instance =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableKeyCell actualImmutableKeyCell = builderResult.build();
    assertEquals(instance, actualImmutableKeyCell);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#kind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#kind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.kind(EntityKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutableKeyCell.builder();

    // Act
    Builder actualKindResult = builderResult.kind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualKindResult);
  }

  /**
   * Test Builder {@link Builder#lifecyclePhase(LifecyclePhase)}.
   *
   * <p>Method under test: {@link Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test Builder lifecyclePhase(LifecyclePhase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lifecyclePhase(LifecyclePhase)"})
  void testBuilderLifecyclePhase() {
    // Arrange
    Builder builderResult = ImmutableKeyCell.builder();

    // Act
    Builder actualLifecyclePhaseResult = builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertSame(builderResult, actualLifecyclePhaseResult);
  }

  /**
   * Test Builder {@link Builder#name(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#name(Optional)}
   */
  @Test
  @DisplayName("Test Builder name(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(Optional)"})
  void testBuilderNameWithOptional() {
    // Arrange
    Builder builderResult = ImmutableKeyCell.builder();
    Optional<String> name = Optional.of("42");

    // Act
    Builder actualNameResult = builderResult.name(name);

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#waltzId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#waltzId(long)}
   */
  @Test
  @DisplayName("Test Builder waltzId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.waltzId(long)"})
  void testBuilderWaltzIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableKeyCell.builder();

    // Act
    Builder actualWaltzIdResult = builderResult.waltzId(1L);

    // Assert
    assertSame(builderResult, actualWaltzIdResult);
  }

  /**
   * Test Builder {@link Builder#waltzId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#waltzId(Optional)}
   */
  @Test
  @DisplayName("Test Builder waltzId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.waltzId(Optional)"})
  void testBuilderWaltzIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableKeyCell.builder();
    Optional<Long> waltzId = Optional.of(42L);

    // Act
    Builder actualWaltzIdResult = builderResult.waltzId(waltzId);

    // Assert
    assertSame(builderResult, actualWaltzIdResult);
  }

  /**
   * Test {@link ImmutableKeyCell#copyOf(KeyCell)}.
   *
   * <ul>
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#copyOf(KeyCell)}
   */
  @Test
  @DisplayName("Test copyOf(KeyCell); then return 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.copyOf(KeyCell)"})
  void testCopyOf_thenReturnType() {
    // Arrange
    ImmutableKeyCell instance =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();

    // Act
    ImmutableKeyCell actualCopyOfResult = ImmutableKeyCell.copyOf(instance);

    // Assert
    assertEquals("Type", actualCopyOfResult.type());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableKeyCell#equals(Object)}, and {@link ImmutableKeyCell#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableKeyCell#equals(Object)}
   *   <li>{@link ImmutableKeyCell#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableKeyCell.equals(Object)", "int ImmutableKeyCell.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();
    ImmutableKeyCell immutableKeyCell2 =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableKeyCell, immutableKeyCell2);
    assertEquals(immutableKeyCell.hashCode(), immutableKeyCell2.hashCode());
  }

  /**
   * Test {@link ImmutableKeyCell#equals(Object)}, and {@link ImmutableKeyCell#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableKeyCell#equals(Object)}
   *   <li>{@link ImmutableKeyCell#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableKeyCell.equals(Object)", "int ImmutableKeyCell.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableKeyCell, immutableKeyCell);
    int expectedHashCodeResult = immutableKeyCell.hashCode();
    assertEquals(expectedHashCodeResult, immutableKeyCell.hashCode());
  }

  /**
   * Test {@link ImmutableKeyCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableKeyCell.equals(Object)", "int ImmutableKeyCell.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("Type")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableKeyCell,
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableKeyCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableKeyCell.equals(Object)", "int ImmutableKeyCell.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ACTOR)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableKeyCell,
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableKeyCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableKeyCell.equals(Object)", "int ImmutableKeyCell.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.DEVELOPMENT)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableKeyCell,
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableKeyCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableKeyCell.equals(Object)", "int ImmutableKeyCell.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Type")
            .type("Type")
            .waltzId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableKeyCell,
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableKeyCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableKeyCell.equals(Object)", "int ImmutableKeyCell.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("externalId")
            .waltzId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableKeyCell,
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableKeyCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableKeyCell.equals(Object)", "int ImmutableKeyCell.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(2L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableKeyCell,
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableKeyCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableKeyCell.equals(Object)", "int ImmutableKeyCell.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableKeyCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableKeyCell.equals(Object)", "int ImmutableKeyCell.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build(),
        "Different type to ImmutableKeyCell");
  }

  /**
   * Test {@link ImmutableKeyCell#externalId()}.
   *
   * <p>Method under test: {@link ImmutableKeyCell#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableKeyCell.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableKeyCell#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) ExternalId is {@code null}.
   *   <li>Then return type is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) ExternalId is 'null'; then return type is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonExternalIdIsNull_thenReturnTypeIsJson() {
    // Arrange
    Json json = new Json();
    json.setType("Json");
    Optional<String> name = Optional.of("42");
    json.setName(name);
    json.setKind(EntityKind.ALL);
    Optional<Long> waltzId = Optional.of(42L);
    json.setWaltzId(waltzId);
    json.setExternalId(null);
    json.setLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Act
    ImmutableKeyCell actualFromJsonResult = ImmutableKeyCell.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.type());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualFromJsonResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableKeyCell#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Name is {@code null}.
   *   <li>Then return type is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Name is 'null'; then return type is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonNameIsNull_thenReturnTypeIsJson() {
    // Arrange
    Json json = new Json();
    json.setType("Json");
    json.setName(null);
    json.setKind(EntityKind.ALL);
    Optional<Long> waltzId = Optional.of(42L);
    json.setWaltzId(waltzId);
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Act
    ImmutableKeyCell actualFromJsonResult = ImmutableKeyCell.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.type());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualFromJsonResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableKeyCell#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Type is {@code Json}.
   *   <li>Then return type is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Type is 'Json'; then return type is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonTypeIsJson_thenReturnTypeIsJson() {
    // Arrange
    Json json = new Json();
    json.setType("Json");
    Optional<String> name = Optional.of("42");
    json.setName(name);
    json.setKind(EntityKind.ALL);
    Optional<Long> waltzId = Optional.of(42L);
    json.setWaltzId(waltzId);
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Act
    ImmutableKeyCell actualFromJsonResult = ImmutableKeyCell.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.type());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualFromJsonResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableKeyCell#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) WaltzId is {@code null}.
   *   <li>Then return type is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) WaltzId is 'null'; then return type is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonWaltzIdIsNull_thenReturnTypeIsJson() {
    // Arrange
    Json json = new Json();
    json.setType("Json");
    Optional<String> name = Optional.of("42");
    json.setName(name);
    json.setKind(EntityKind.ALL);
    json.setWaltzId(null);
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Act
    ImmutableKeyCell actualFromJsonResult = ImmutableKeyCell.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.type());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualFromJsonResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableKeyCell#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Type is {@code null}.
   *   <li>Then return type is {@link ApiTypes#KEYCELL}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Type is 'null'; then return type is KEYCELL")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonTypeIsNull_thenReturnTypeIsKeycell() {
    // Arrange
    Json json = new Json();
    json.setType(null);
    Optional<String> name = Optional.of("42");
    json.setName(name);
    json.setKind(EntityKind.ALL);
    Optional<Long> waltzId = Optional.of(42L);
    json.setWaltzId(waltzId);
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Act
    ImmutableKeyCell actualFromJsonResult = ImmutableKeyCell.fromJson(json);

    // Assert
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualFromJsonResult.lifecyclePhase());
    assertEquals(ApiTypes.KEYCELL, actualFromJsonResult.type());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableKeyCell#kind()}
   *   <li>{@link ImmutableKeyCell#lifecyclePhase()}
   *   <li>{@link ImmutableKeyCell#type()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityKind ImmutableKeyCell.kind()",
    "LifecyclePhase ImmutableKeyCell.lifecyclePhase()",
    "String ImmutableKeyCell.type()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();

    // Act
    EntityKind actualKindResult = immutableKeyCell.kind();
    LifecyclePhase actualLifecyclePhaseResult = immutableKeyCell.lifecyclePhase();

    // Assert
    assertEquals("Type", immutableKeyCell.type());
    assertEquals(EntityKind.ALL, actualKindResult);
    assertEquals(LifecyclePhase.PRODUCTION, actualLifecyclePhaseResult);
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
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
  }

  /**
   * Test Json {@link Json#lifecyclePhase()}.
   *
   * <p>Method under test: {@link Json#lifecyclePhase()}
   */
  @Test
  @DisplayName("Test Json lifecyclePhase()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LifecyclePhase Json.lifecyclePhase()"})
  void testJsonLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lifecyclePhase());
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
  @MethodsUnderTest({"Optional Json.name()"})
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
    assertNull(actualJson.type);
    assertNull(actualJson.kind);
    assertNull(actualJson.lifecyclePhase);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.name.isPresent());
    assertFalse(actualJson.waltzId.isPresent());
  }

  /**
   * Test Json {@link Json#type()}.
   *
   * <p>Method under test: {@link Json#type()}
   */
  @Test
  @DisplayName("Test Json type()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.type()"})
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().type());
  }

  /**
   * Test Json {@link Json#waltzId()}.
   *
   * <p>Method under test: {@link Json#waltzId()}
   */
  @Test
  @DisplayName("Test Json waltzId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.waltzId()"})
  void testJsonWaltzId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().waltzId());
  }

  /**
   * Test {@link ImmutableKeyCell#name()}.
   *
   * <p>Method under test: {@link ImmutableKeyCell#name()}
   */
  @Test
  @DisplayName("Test name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableKeyCell.name()"})
  void testName() {
    // Arrange and Act
    Optional<String> actualNameResult =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build()
            .name();

    // Assert
    assertEquals("Name", actualNameResult.get());
    assertTrue(actualNameResult.isPresent());
  }

  /**
   * Test {@link ImmutableKeyCell#toString()}.
   *
   * <p>Method under test: {@link ImmutableKeyCell#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableKeyCell.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "KeyCell{type=Type, name=Name, kind=ALL, waltzId=1, externalId=42, lifecyclePhase=PRODUCTION}",
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableKeyCell#waltzId()}.
   *
   * <p>Method under test: {@link ImmutableKeyCell#waltzId()}
   */
  @Test
  @DisplayName("Test waltzId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableKeyCell.waltzId()"})
  void testWaltzId() {
    // Arrange and Act
    Optional<Long> actualWaltzIdResult =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build()
            .waltzId();

    // Assert
    assertEquals(1L, actualWaltzIdResult.get().longValue());
    assertTrue(actualWaltzIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableKeyCell#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableKeyCell#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableKeyCell actualWithExternalIdResult = immutableKeyCell.withExternalId(optional);

    // Assert
    assertSame(immutableKeyCell, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableKeyCell#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; then return 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_thenReturnType() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("External Id")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableKeyCell actualWithExternalIdResult = immutableKeyCell.withExternalId(optional);

    // Assert
    assertEquals("Type", actualWithExternalIdResult.type());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithExternalIdResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableKeyCell#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableKeyCell#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();

    // Act
    ImmutableKeyCell actualWithExternalIdResult = immutableKeyCell.withExternalId("42");

    // Assert
    assertSame(immutableKeyCell, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableKeyCell#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.withExternalId(String)"})
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnType() {
    // Arrange and Act
    ImmutableKeyCell actualWithExternalIdResult =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Type", actualWithExternalIdResult.type());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithExternalIdResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableKeyCell#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableKeyCell#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();

    // Act
    ImmutableKeyCell actualWithKindResult = immutableKeyCell.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableKeyCell, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableKeyCell#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.withKind(EntityKind)"})
  void testWithKind_thenReturnType() {
    // Arrange and Act
    ImmutableKeyCell actualWithKindResult =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ACTOR)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("Type", actualWithKindResult.type());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithKindResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableKeyCell#withLifecyclePhase(LifecyclePhase)}.
   *
   * <p>Method under test: {@link ImmutableKeyCell#withLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test withLifecyclePhase(LifecyclePhase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.withLifecyclePhase(LifecyclePhase)"})
  void testWithLifecyclePhase() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();

    // Act
    ImmutableKeyCell actualWithLifecyclePhaseResult =
        immutableKeyCell.withLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertSame(immutableKeyCell, actualWithLifecyclePhaseResult);
  }

  /**
   * Test {@link ImmutableKeyCell#withLifecyclePhase(LifecyclePhase)}.
   *
   * <ul>
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#withLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test withLifecyclePhase(LifecyclePhase); then return 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.withLifecyclePhase(LifecyclePhase)"})
  void testWithLifecyclePhase_thenReturnType() {
    // Arrange and Act
    ImmutableKeyCell actualWithLifecyclePhaseResult =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.DEVELOPMENT)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build()
            .withLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertEquals("Type", actualWithLifecyclePhaseResult.type());
    assertEquals(EntityKind.ALL, actualWithLifecyclePhaseResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithLifecyclePhaseResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableKeyCell#withName(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableKeyCell#withName(Optional)}
   */
  @Test
  @DisplayName("Test withName(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.withName(Optional)"})
  void testWithNameWithOptional() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("42")
            .type("Type")
            .waltzId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableKeyCell actualWithNameResult = immutableKeyCell.withName(optional);

    // Assert
    assertSame(immutableKeyCell, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableKeyCell#withName(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#withName(Optional)}
   */
  @Test
  @DisplayName("Test withName(Optional) with 'optional'; then return 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.withName(Optional)"})
  void testWithNameWithOptional_thenReturnType() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableKeyCell actualWithNameResult = immutableKeyCell.withName(optional);

    // Assert
    assertEquals("Type", actualWithNameResult.type());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithNameResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableKeyCell#withName(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableKeyCell#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.withName(String)"})
  void testWithNameWithValue() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("42")
            .type("Type")
            .waltzId(1L)
            .build();

    // Act
    ImmutableKeyCell actualWithNameResult = immutableKeyCell.withName("42");

    // Assert
    assertSame(immutableKeyCell, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableKeyCell#withName(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String) with 'value'; then return 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.withName(String)"})
  void testWithNameWithValue_thenReturnType() {
    // Arrange and Act
    ImmutableKeyCell actualWithNameResult =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build()
            .withName("42");

    // Assert
    assertEquals("Type", actualWithNameResult.type());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithNameResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableKeyCell#withType(String)}.
   *
   * <p>Method under test: {@link ImmutableKeyCell#withType(String)}
   */
  @Test
  @DisplayName("Test withType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.withType(String)"})
  void testWithType() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("42")
            .waltzId(1L)
            .build();

    // Act
    ImmutableKeyCell actualWithTypeResult = immutableKeyCell.withType("42");

    // Assert
    assertSame(immutableKeyCell, actualWithTypeResult);
  }

  /**
   * Test {@link ImmutableKeyCell#withType(String)}.
   *
   * <ul>
   *   <li>Then return type is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#withType(String)}
   */
  @Test
  @DisplayName("Test withType(String); then return type is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.withType(String)"})
  void testWithType_thenReturnTypeIs42() {
    // Arrange and Act
    ImmutableKeyCell actualWithTypeResult =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build()
            .withType("42");

    // Assert
    assertEquals("42", actualWithTypeResult.type());
    assertEquals(EntityKind.ALL, actualWithTypeResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithTypeResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableKeyCell#withWaltzId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableKeyCell#withWaltzId(Optional)}
   */
  @Test
  @DisplayName("Test withWaltzId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.withWaltzId(Optional)"})
  void testWithWaltzIdWithOptional() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableKeyCell actualWithWaltzIdResult = immutableKeyCell.withWaltzId(optional);

    // Assert
    assertSame(immutableKeyCell, actualWithWaltzIdResult);
  }

  /**
   * Test {@link ImmutableKeyCell#withWaltzId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#withWaltzId(Optional)}
   */
  @Test
  @DisplayName("Test withWaltzId(Optional) with 'optional'; when of forty-two; then return 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.withWaltzId(Optional)"})
  void testWithWaltzIdWithOptional_whenOfFortyTwo_thenReturnType() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableKeyCell actualWithWaltzIdResult = immutableKeyCell.withWaltzId(optional);

    // Assert
    assertEquals("Type", actualWithWaltzIdResult.type());
    assertEquals(EntityKind.ALL, actualWithWaltzIdResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithWaltzIdResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableKeyCell#withWaltzId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableKeyCell#withWaltzId(long)}
   */
  @Test
  @DisplayName("Test withWaltzId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.withWaltzId(long)"})
  void testWithWaltzIdWithValue() {
    // Arrange
    ImmutableKeyCell immutableKeyCell =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();

    // Act
    ImmutableKeyCell actualWithWaltzIdResult = immutableKeyCell.withWaltzId(1L);

    // Assert
    assertSame(immutableKeyCell, actualWithWaltzIdResult);
  }

  /**
   * Test {@link ImmutableKeyCell#withWaltzId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableKeyCell#withWaltzId(long)}
   */
  @Test
  @DisplayName("Test withWaltzId(long) with 'value'; when forty-two; then return 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableKeyCell ImmutableKeyCell.withWaltzId(long)"})
  void testWithWaltzIdWithValue_whenFortyTwo_thenReturnType() {
    // Arrange and Act
    ImmutableKeyCell actualWithWaltzIdResult =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build()
            .withWaltzId(42L);

    // Assert
    assertEquals("Type", actualWithWaltzIdResult.type());
    assertEquals(EntityKind.ALL, actualWithWaltzIdResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithWaltzIdResult.lifecyclePhase());
  }
}
