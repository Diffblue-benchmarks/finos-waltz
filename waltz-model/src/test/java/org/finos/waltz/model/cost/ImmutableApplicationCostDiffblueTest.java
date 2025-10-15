package org.finos.waltz.model.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.cost.ImmutableApplicationCost.Builder;
import org.finos.waltz.model.cost.ImmutableApplicationCost.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationCostDiffblueTest {
  /**
   * Test Builder {@link Builder#application(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#application(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder application(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.application(EntityReference)"})
  void testBuilderApplication_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationCost.builder();

    // Act
    Builder actualApplicationResult = builderResult.application(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualApplicationResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationCost Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableApplicationCost.builder();
    ImmutableEntityReference application =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualApplicationResult = actualBuilderResult.application(application);
    ImmutableCost.Builder builderResult = ImmutableCost.builder();
    ImmutableCost cost =
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build();
    ImmutableApplicationCost actualImmutableApplicationCost =
        actualApplicationResult.cost(cost).build();

    // Assert
    assertSame(application, actualImmutableApplicationCost.application());
    assertSame(cost, actualImmutableApplicationCost.cost());
  }

  /**
   * Test Builder {@link Builder#cost(Cost)}.
   *
   * <ul>
   *   <li>When {@link ImmutableCost.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#cost(Cost)}
   */
  @Test
  @DisplayName("Test Builder cost(Cost); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.cost(Cost)"})
  void testBuilderCost_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationCost.builder();

    // Act
    Builder actualCostResult = builderResult.cost(new ImmutableCost.Json());

    // Assert
    assertSame(builderResult, actualCostResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationCost)}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationCost)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationCost)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationCost)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableApplicationCost.builder();

    Builder builderResult2 = ImmutableApplicationCost.builder();

    Builder applicationResult =
        builderResult2.application(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableCost.Builder builderResult3 = ImmutableCost.builder();
    ImmutableApplicationCost instance =
        applicationResult
            .cost(
                builderResult3
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableApplicationCost actualImmutableApplicationCost = builderResult.build();
    assertEquals(instance, actualImmutableApplicationCost);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableApplicationCost#copyOf(ApplicationCost)}.
   *
   * <ul>
   *   <li>Then application return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationCost#copyOf(ApplicationCost)}
   */
  @Test
  @DisplayName("Test copyOf(ApplicationCost); then application return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationCost ImmutableApplicationCost.copyOf(ApplicationCost)"})
  void testCopyOf_thenApplicationReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableApplicationCost.builder();

    Builder applicationResult =
        builderResult.application(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableCost.Builder builderResult2 = ImmutableCost.builder();
    ImmutableApplicationCost instance =
        applicationResult
            .cost(
                builderResult2
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .build();

    // Act
    ImmutableApplicationCost actualCopyOfResult = ImmutableApplicationCost.copyOf(instance);

    // Assert
    EntityReference applicationResult2 = actualCopyOfResult.application();
    assertTrue(applicationResult2 instanceof ImmutableEntityReference);
    Cost costResult = actualCopyOfResult.cost();
    assertTrue(costResult instanceof ImmutableCost);
    assertEquals("Cost Kind", costResult.costKind());
    assertEquals("The characteristics of someone or something", applicationResult2.description());
    assertEquals(1, costResult.year());
    assertEquals(1L, applicationResult2.id());
    assertEquals(EntityKind.ALL, applicationResult2.kind());
    assertEquals(EntityKind.ALL, costResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, applicationResult2.entityLifecycleStatus());
    BigDecimal expectedAmountResult = new BigDecimal("2.3");
    assertEquals(expectedAmountResult, costResult.amount());
  }

  /**
   * Test {@link ImmutableApplicationCost#equals(Object)}, and {@link
   * ImmutableApplicationCost#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationCost#equals(Object)}
   *   <li>{@link ImmutableApplicationCost#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationCost.equals(Object)",
    "int ImmutableApplicationCost.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationCost.builder();

    Builder applicationResult =
        builderResult.application(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableCost.Builder builderResult2 = ImmutableCost.builder();
    ImmutableApplicationCost immutableApplicationCost =
        applicationResult
            .cost(
                builderResult2
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .build();

    Builder builderResult3 = ImmutableApplicationCost.builder();

    Builder applicationResult2 =
        builderResult3.application(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableCost.Builder builderResult4 = ImmutableCost.builder();
    ImmutableApplicationCost immutableApplicationCost2 =
        applicationResult2
            .cost(
                builderResult4
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableApplicationCost, immutableApplicationCost2);
    assertEquals(immutableApplicationCost.hashCode(), immutableApplicationCost2.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationCost#equals(Object)}, and {@link
   * ImmutableApplicationCost#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationCost#equals(Object)}
   *   <li>{@link ImmutableApplicationCost#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationCost.equals(Object)",
    "int ImmutableApplicationCost.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationCost.builder();

    Builder applicationResult =
        builderResult.application(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableCost.Builder builderResult2 = ImmutableCost.builder();
    ImmutableApplicationCost immutableApplicationCost =
        applicationResult
            .cost(
                builderResult2
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableApplicationCost, immutableApplicationCost);
    int expectedHashCodeResult = immutableApplicationCost.hashCode();
    assertEquals(expectedHashCodeResult, immutableApplicationCost.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationCost#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationCost#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationCost.equals(Object)",
    "int ImmutableApplicationCost.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationCost.builder();

    Builder applicationResult =
        builderResult.application(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableCost.Builder builderResult2 = ImmutableCost.builder();
    ImmutableApplicationCost immutableApplicationCost =
        applicationResult
            .cost(
                builderResult2
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .build();

    Builder builderResult3 = ImmutableApplicationCost.builder();

    Builder applicationResult2 =
        builderResult3.application(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableCost.Builder builderResult4 = ImmutableCost.builder();

    // Act and Assert
    assertNotEquals(
        immutableApplicationCost,
        applicationResult2
            .cost(
                builderResult4
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableApplicationCost#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationCost#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationCost.equals(Object)",
    "int ImmutableApplicationCost.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableApplicationCost.builder();

    Builder applicationResult =
        builderResult.application(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableCost.Builder builderResult2 = ImmutableCost.builder();
    ImmutableApplicationCost immutableApplicationCost =
        applicationResult
            .cost(
                builderResult2
                    .amount(new BigDecimal("4.5"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .build();

    Builder builderResult3 = ImmutableApplicationCost.builder();

    Builder applicationResult2 =
        builderResult3.application(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableCost.Builder builderResult4 = ImmutableCost.builder();

    // Act and Assert
    assertNotEquals(
        immutableApplicationCost,
        applicationResult2
            .cost(
                builderResult4
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableApplicationCost#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationCost#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationCost.equals(Object)",
    "int ImmutableApplicationCost.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationCost.builder();

    Builder applicationResult =
        builderResult.application(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableCost.Builder builderResult2 = ImmutableCost.builder();

    // Act and Assert
    assertNotEquals(
        applicationResult
            .cost(
                builderResult2
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableApplicationCost#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationCost#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationCost.equals(Object)",
    "int ImmutableApplicationCost.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationCost.builder();

    Builder applicationResult =
        builderResult.application(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableCost.Builder builderResult2 = ImmutableCost.builder();

    // Act and Assert
    assertNotEquals(
        applicationResult
            .cost(
                builderResult2
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .build(),
        "Different type to ImmutableApplicationCost");
  }

  /**
   * Test {@link ImmutableApplicationCost#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return application is {@link Json} (default constructor) {@link Json#application}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationCost#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return application is Json (default constructor) application")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationCost ImmutableApplicationCost.fromJson(Json)"})
  void testFromJson_thenReturnApplicationIsJsonApplication() {
    // Arrange
    Json json = new Json();

    ImmutableCost.Builder builderResult = ImmutableCost.builder();
    json.setCost(
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build());
    json.setApplication(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableApplicationCost actualFromJsonResult = ImmutableApplicationCost.fromJson(json);

    // Assert
    EntityReference expectedApplicationResult = json.application;
    assertSame(expectedApplicationResult, actualFromJsonResult.application());
    Cost expectedCostResult = json.cost;
    assertSame(expectedCostResult, actualFromJsonResult.cost());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationCost#toString()}
   *   <li>{@link ImmutableApplicationCost#application()}
   *   <li>{@link ImmutableApplicationCost#cost()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableApplicationCost.application()",
    "Cost ImmutableApplicationCost.cost()",
    "String ImmutableApplicationCost.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableApplicationCost.builder();

    Builder applicationResult =
        builderResult.application(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableCost.Builder builderResult2 = ImmutableCost.builder();
    ImmutableApplicationCost immutableApplicationCost =
        applicationResult
            .cost(
                builderResult2
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableApplicationCost.toString();
    EntityReference actualApplicationResult = immutableApplicationCost.application();

    // Assert
    assertTrue(actualApplicationResult instanceof ImmutableEntityReference);
    assertTrue(immutableApplicationCost.cost() instanceof ImmutableCost);
    assertEquals(
        "ApplicationCost{cost=Cost{amount=2.3, costKind=Cost Kind, year=1, kind=ALL}, application=EntityReference"
            + "{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}}",
        actualToStringResult);
  }

  /**
   * Test Json {@link Json#application()}.
   *
   * <p>Method under test: {@link Json#application()}
   */
  @Test
  @DisplayName("Test Json application()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.application()"})
  void testJsonApplication() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().application());
  }

  /**
   * Test Json {@link Json#cost()}.
   *
   * <p>Method under test: {@link Json#cost()}
   */
  @Test
  @DisplayName("Test Json cost()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Cost Json.cost()"})
  void testJsonCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().cost());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setApplication(EntityReference)}
   *   <li>{@link Json#setCost(Cost)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setApplication(EntityReference)",
    "void Json.setCost(Cost)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setApplication(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableCost.Builder builderResult = ImmutableCost.builder();
    BigDecimal amount = new BigDecimal("2.3");
    actualJson.setCost(
        builderResult.amount(amount).costKind("Cost Kind").kind(EntityKind.ALL).year(1).build());

    // Assert
    EntityReference entityReference = actualJson.application;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    Cost cost = actualJson.cost;
    assertTrue(cost instanceof ImmutableCost);
    assertEquals("Cost Kind", cost.costKind());
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(1, cost.year());
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityKind.ALL, cost.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
    BigDecimal expectedAmountResult = new BigDecimal("2.3");
    BigDecimal amountResult = cost.amount();
    assertEquals(expectedAmountResult, amountResult);
    assertSame(amount, amountResult);
  }

  /**
   * Test {@link ImmutableApplicationCost#withApplication(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableApplicationCost#withApplication(EntityReference)}
   */
  @Test
  @DisplayName("Test withApplication(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationCost ImmutableApplicationCost.withApplication(EntityReference)"
  })
  void testWithApplication() {
    // Arrange
    Builder builderResult = ImmutableApplicationCost.builder();

    Builder applicationResult =
        builderResult.application(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableCost.Builder builderResult2 = ImmutableCost.builder();
    ImmutableApplicationCost immutableApplicationCost =
        applicationResult
            .cost(
                builderResult2
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .build();

    // Act
    ImmutableApplicationCost actualWithApplicationResult =
        immutableApplicationCost.withApplication(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableApplicationCost, actualWithApplicationResult);
  }

  /**
   * Test {@link ImmutableApplicationCost#withCost(Cost)}.
   *
   * <p>Method under test: {@link ImmutableApplicationCost#withCost(Cost)}
   */
  @Test
  @DisplayName("Test withCost(Cost)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationCost ImmutableApplicationCost.withCost(Cost)"})
  void testWithCost() {
    // Arrange
    Builder builderResult = ImmutableApplicationCost.builder();

    Builder applicationResult =
        builderResult.application(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableCost.Builder builderResult2 = ImmutableCost.builder();
    ImmutableApplicationCost immutableApplicationCost =
        applicationResult
            .cost(
                builderResult2
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .build();

    ImmutableCost.Builder builderResult3 = ImmutableCost.builder();

    // Act
    ImmutableApplicationCost actualWithCostResult =
        immutableApplicationCost.withCost(
            builderResult3
                .amount(new BigDecimal("2.3"))
                .costKind("Cost Kind")
                .kind(EntityKind.ALL)
                .year(1)
                .build());

    // Assert
    assertEquals(immutableApplicationCost, actualWithCostResult);
  }
}
