package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.ChangeDirection;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAppChangeEntry.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAppChangeEntry.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppChangeEntryDiffblueTest {
  /**
   * Test Builder {@link Builder#appRef(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#appRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder appRef(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.appRef(EntityReference)"})
  void testBuilderAppRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();

    // Act
    Builder actualAppRefResult = builderResult.appRef(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualAppRefResult);
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
  @MethodsUnderTest({"ImmutableAppChangeEntry Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAppChangeEntry.builder();
    ImmutableEntityReference appRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    LocalDate date = LocalDate.of(1970, 1, 1);
    ImmutableAppChangeEntry actualImmutableAppChangeEntry =
        actualBuilderResult
            .appRef(appRef)
            .changeDirection(ChangeDirection.INBOUND)
            .date(date)
            .build();

    // Assert
    LocalDate dateResult = actualImmutableAppChangeEntry.date();
    assertEquals("1970-01-01", dateResult.toString());
    assertEquals(ChangeDirection.INBOUND, actualImmutableAppChangeEntry.changeDirection());
    assertSame(appRef, actualImmutableAppChangeEntry.appRef());
    assertSame(date, dateResult);
  }

  /**
   * Test Builder {@link Builder#changeDirection(ChangeDirection)}.
   *
   * <p>Method under test: {@link Builder#changeDirection(ChangeDirection)}
   */
  @Test
  @DisplayName("Test Builder changeDirection(ChangeDirection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changeDirection(ChangeDirection)"})
  void testBuilderChangeDirection() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();

    // Act
    Builder actualChangeDirectionResult = builderResult.changeDirection(ChangeDirection.INBOUND);

    // Assert
    assertSame(builderResult, actualChangeDirectionResult);
  }

  /**
   * Test Builder {@link Builder#date(LocalDate)}.
   *
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#date(LocalDate)}
   */
  @Test
  @DisplayName(
      "Test Builder date(LocalDate); when LocalDate with '1970' and one and one; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.date(LocalDate)"})
  void testBuilderDate_whenLocalDateWith1970AndOneAndOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();

    // Act
    Builder actualDateResult = builderResult.date(LocalDate.of(1970, 1, 1));

    // Assert
    assertSame(builderResult, actualDateResult);
  }

  /**
   * Test Builder {@link Builder#from(AppChangeEntry)}.
   *
   * <p>Method under test: {@link Builder#from(AppChangeEntry)}
   */
  @Test
  @DisplayName("Test Builder from(AppChangeEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppChangeEntry)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();

    Builder builderResult2 = ImmutableAppChangeEntry.builder();
    ImmutableAppChangeEntry instance =
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAppChangeEntry actualImmutableAppChangeEntry = builderResult.build();
    assertEquals(instance, actualImmutableAppChangeEntry);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableAppChangeEntry#copyOf(AppChangeEntry)}.
   *
   * <ul>
   *   <li>Then appRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeEntry#copyOf(AppChangeEntry)}
   */
  @Test
  @DisplayName("Test copyOf(AppChangeEntry); then appRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppChangeEntry ImmutableAppChangeEntry.copyOf(AppChangeEntry)"})
  void testCopyOf_thenAppRefReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();
    LocalDate date = LocalDate.of(1970, 1, 1);
    ImmutableAppChangeEntry instance =
        builderResult
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(date)
            .build();

    // Act
    ImmutableAppChangeEntry actualCopyOfResult = ImmutableAppChangeEntry.copyOf(instance);

    // Assert
    EntityReference appRefResult = actualCopyOfResult.appRef();
    assertTrue(appRefResult instanceof ImmutableEntityReference);
    LocalDate dateResult = actualCopyOfResult.date();
    assertEquals("1970-01-01", dateResult.toString());
    assertEquals("The characteristics of someone or something", appRefResult.description());
    assertEquals(1L, appRefResult.id());
    assertEquals(ChangeDirection.INBOUND, actualCopyOfResult.changeDirection());
    assertEquals(EntityKind.ALL, appRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, appRefResult.entityLifecycleStatus());
    assertSame(date, dateResult);
  }

  /**
   * Test {@link ImmutableAppChangeEntry#equals(Object)}, and {@link
   * ImmutableAppChangeEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppChangeEntry#equals(Object)}
   *   <li>{@link ImmutableAppChangeEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppChangeEntry.equals(Object)",
    "int ImmutableAppChangeEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();
    ImmutableAppChangeEntry immutableAppChangeEntry =
        builderResult
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build();

    Builder builderResult2 = ImmutableAppChangeEntry.builder();
    ImmutableAppChangeEntry immutableAppChangeEntry2 =
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertEquals(immutableAppChangeEntry, immutableAppChangeEntry2);
    assertEquals(immutableAppChangeEntry.hashCode(), immutableAppChangeEntry2.hashCode());
  }

  /**
   * Test {@link ImmutableAppChangeEntry#equals(Object)}, and {@link
   * ImmutableAppChangeEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppChangeEntry#equals(Object)}
   *   <li>{@link ImmutableAppChangeEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppChangeEntry.equals(Object)",
    "int ImmutableAppChangeEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();
    ImmutableAppChangeEntry immutableAppChangeEntry =
        builderResult
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertEquals(immutableAppChangeEntry, immutableAppChangeEntry);
    int expectedHashCodeResult = immutableAppChangeEntry.hashCode();
    assertEquals(expectedHashCodeResult, immutableAppChangeEntry.hashCode());
  }

  /**
   * Test {@link ImmutableAppChangeEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppChangeEntry.equals(Object)",
    "int ImmutableAppChangeEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();
    ImmutableAppChangeEntry immutableAppChangeEntry =
        builderResult
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build();

    Builder builderResult2 = ImmutableAppChangeEntry.builder();

    // Act and Assert
    assertNotEquals(
        immutableAppChangeEntry,
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());
  }

  /**
   * Test {@link ImmutableAppChangeEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppChangeEntry.equals(Object)",
    "int ImmutableAppChangeEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();
    ImmutableAppChangeEntry immutableAppChangeEntry =
        builderResult
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.OUTBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build();

    Builder builderResult2 = ImmutableAppChangeEntry.builder();

    // Act and Assert
    assertNotEquals(
        immutableAppChangeEntry,
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());
  }

  /**
   * Test {@link ImmutableAppChangeEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppChangeEntry.equals(Object)",
    "int ImmutableAppChangeEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();
    ImmutableAppChangeEntry immutableAppChangeEntry =
        builderResult
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.now())
            .build();

    Builder builderResult2 = ImmutableAppChangeEntry.builder();

    // Act and Assert
    assertNotEquals(
        immutableAppChangeEntry,
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());
  }

  /**
   * Test {@link ImmutableAppChangeEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppChangeEntry.equals(Object)",
    "int ImmutableAppChangeEntry.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAppChangeEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppChangeEntry.equals(Object)",
    "int ImmutableAppChangeEntry.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build(),
        "Different type to ImmutableAppChangeEntry");
  }

  /**
   * Test {@link ImmutableAppChangeEntry#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return date toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeEntry#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return date toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppChangeEntry ImmutableAppChangeEntry.fromJson(Json)"})
  void testFromJson_thenReturnDateToStringIs19700101() {
    // Arrange
    Json json = new Json();
    json.setAppRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setChangeDirection(ChangeDirection.INBOUND);
    LocalDate date = LocalDate.of(1970, 1, 1);
    json.setDate(date);

    // Act
    ImmutableAppChangeEntry actualFromJsonResult = ImmutableAppChangeEntry.fromJson(json);

    // Assert
    LocalDate dateResult = actualFromJsonResult.date();
    assertEquals("1970-01-01", dateResult.toString());
    assertEquals(ChangeDirection.INBOUND, actualFromJsonResult.changeDirection());
    assertSame(date, dateResult);
    EntityReference expectedAppRefResult = json.appRef;
    assertSame(expectedAppRefResult, actualFromJsonResult.appRef());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppChangeEntry#toString()}
   *   <li>{@link ImmutableAppChangeEntry#appRef()}
   *   <li>{@link ImmutableAppChangeEntry#changeDirection()}
   *   <li>{@link ImmutableAppChangeEntry#date()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableAppChangeEntry.appRef()",
    "ChangeDirection ImmutableAppChangeEntry.changeDirection()",
    "LocalDate ImmutableAppChangeEntry.date()",
    "String ImmutableAppChangeEntry.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();
    LocalDate date = LocalDate.of(1970, 1, 1);
    ImmutableAppChangeEntry immutableAppChangeEntry =
        builderResult
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(date)
            .build();

    // Act
    String actualToStringResult = immutableAppChangeEntry.toString();
    EntityReference actualAppRefResult = immutableAppChangeEntry.appRef();
    ChangeDirection actualChangeDirectionResult = immutableAppChangeEntry.changeDirection();
    LocalDate actualDateResult = immutableAppChangeEntry.date();

    // Assert
    assertTrue(actualAppRefResult instanceof ImmutableEntityReference);
    assertEquals("1970-01-01", actualDateResult.toString());
    assertEquals(
        "AppChangeEntry{appRef=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, changeDirection=INBOUND,"
            + " date=1970-01-01}",
        actualToStringResult);
    assertEquals(ChangeDirection.INBOUND, actualChangeDirectionResult);
    assertSame(date, actualDateResult);
  }

  /**
   * Test Json {@link Json#appRef()}.
   *
   * <p>Method under test: {@link Json#appRef()}
   */
  @Test
  @DisplayName("Test Json appRef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.appRef()"})
  void testJsonAppRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().appRef());
  }

  /**
   * Test Json {@link Json#changeDirection()}.
   *
   * <p>Method under test: {@link Json#changeDirection()}
   */
  @Test
  @DisplayName("Test Json changeDirection()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChangeDirection Json.changeDirection()"})
  void testJsonChangeDirection() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().changeDirection());
  }

  /**
   * Test Json {@link Json#date()}.
   *
   * <p>Method under test: {@link Json#date()}
   */
  @Test
  @DisplayName("Test Json date()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate Json.date()"})
  void testJsonDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().date());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAppRef(EntityReference)}
   *   <li>{@link Json#setChangeDirection(ChangeDirection)}
   *   <li>{@link Json#setDate(LocalDate)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setAppRef(EntityReference)",
    "void Json.setChangeDirection(ChangeDirection)",
    "void Json.setDate(LocalDate)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAppRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setChangeDirection(ChangeDirection.INBOUND);
    actualJson.setDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals("1970-01-01", actualJson.date.toString());
  }

  /**
   * Test {@link ImmutableAppChangeEntry#withAppRef(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableAppChangeEntry#withAppRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withAppRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppChangeEntry ImmutableAppChangeEntry.withAppRef(EntityReference)"})
  void testWithAppRef() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();
    ImmutableAppChangeEntry immutableAppChangeEntry =
        builderResult
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableAppChangeEntry actualWithAppRefResult =
        immutableAppChangeEntry.withAppRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableAppChangeEntry, actualWithAppRefResult);
  }

  /**
   * Test {@link ImmutableAppChangeEntry#withChangeDirection(ChangeDirection)}.
   *
   * <p>Method under test: {@link ImmutableAppChangeEntry#withChangeDirection(ChangeDirection)}
   */
  @Test
  @DisplayName("Test withChangeDirection(ChangeDirection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppChangeEntry ImmutableAppChangeEntry.withChangeDirection(ChangeDirection)"
  })
  void testWithChangeDirection() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();
    ImmutableAppChangeEntry immutableAppChangeEntry =
        builderResult
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableAppChangeEntry actualWithChangeDirectionResult =
        immutableAppChangeEntry.withChangeDirection(ChangeDirection.INBOUND);

    // Assert
    assertSame(immutableAppChangeEntry, actualWithChangeDirectionResult);
  }

  /**
   * Test {@link ImmutableAppChangeEntry#withChangeDirection(ChangeDirection)}.
   *
   * <ul>
   *   <li>Then appRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeEntry#withChangeDirection(ChangeDirection)}
   */
  @Test
  @DisplayName(
      "Test withChangeDirection(ChangeDirection); then appRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppChangeEntry ImmutableAppChangeEntry.withChangeDirection(ChangeDirection)"
  })
  void testWithChangeDirection_thenAppRefReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();
    LocalDate date = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAppChangeEntry actualWithChangeDirectionResult =
        builderResult
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.OUTBOUND)
            .date(date)
            .build()
            .withChangeDirection(ChangeDirection.INBOUND);

    // Assert
    EntityReference appRefResult = actualWithChangeDirectionResult.appRef();
    assertTrue(appRefResult instanceof ImmutableEntityReference);
    LocalDate dateResult = actualWithChangeDirectionResult.date();
    assertEquals("1970-01-01", dateResult.toString());
    assertEquals("The characteristics of someone or something", appRefResult.description());
    assertEquals(1L, appRefResult.id());
    assertEquals(ChangeDirection.INBOUND, actualWithChangeDirectionResult.changeDirection());
    assertEquals(EntityKind.ALL, appRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, appRefResult.entityLifecycleStatus());
    assertSame(date, dateResult);
  }

  /**
   * Test {@link ImmutableAppChangeEntry#withDate(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableAppChangeEntry#withDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppChangeEntry ImmutableAppChangeEntry.withDate(LocalDate)"})
  void testWithDate() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();
    ImmutableAppChangeEntry immutableAppChangeEntry =
        builderResult
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableAppChangeEntry actualWithDateResult =
        immutableAppChangeEntry.withDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableAppChangeEntry, actualWithDateResult);
  }
}
