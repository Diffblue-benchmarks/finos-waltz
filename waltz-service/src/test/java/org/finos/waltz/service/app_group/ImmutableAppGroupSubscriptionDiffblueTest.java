package org.finos.waltz.service.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.app_group.AppGroup;
import org.finos.waltz.model.app_group.AppGroupKind;
import org.finos.waltz.model.app_group.AppGroupMemberRole;
import org.finos.waltz.model.app_group.ImmutableAppGroup;
import org.finos.waltz.service.app_group.ImmutableAppGroupSubscription.Builder;
import org.finos.waltz.service.app_group.ImmutableAppGroupSubscription.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppGroupSubscriptionDiffblueTest {
  /**
   * Test Builder {@link Builder#appGroup(AppGroup)}.
   *
   * <p>Method under test: {@link Builder#appGroup(AppGroup)}
   */
  @Test
  @DisplayName("Test Builder appGroup(AppGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.appGroup(AppGroup)"})
  void testBuilderAppGroup() {
    // Arrange
    Builder builderResult = ImmutableAppGroupSubscription.builder();

    // Act
    Builder actualAppGroupResult = builderResult.appGroup(mock(AppGroup.class));

    // Assert
    assertSame(builderResult, actualAppGroupResult);
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
  @MethodsUnderTest({"ImmutableAppGroupSubscription Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAppGroupSubscription.builder();
    ImmutableAppGroup appGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableAppGroupSubscription actualImmutableAppGroupSubscription =
        actualBuilderResult.appGroup(appGroup).role(AppGroupMemberRole.VIEWER).build();

    // Assert
    assertEquals(AppGroupMemberRole.VIEWER, actualImmutableAppGroupSubscription.role());
    assertSame(appGroup, actualImmutableAppGroupSubscription.appGroup());
  }

  /**
   * Test Builder {@link Builder#from(AppGroupSubscription)}.
   *
   * <p>Method under test: {@link Builder#from(AppGroupSubscription)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroupSubscription)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppGroupSubscription)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAppGroupSubscription.builder();

    Builder builderResult2 = ImmutableAppGroupSubscription.builder();
    ImmutableAppGroupSubscription instance =
        builderResult2
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .role(AppGroupMemberRole.VIEWER)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAppGroupSubscription actualImmutableAppGroupSubscription = builderResult.build();
    assertEquals(instance, actualImmutableAppGroupSubscription);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#role(AppGroupMemberRole)}.
   *
   * <p>Method under test: {@link Builder#role(AppGroupMemberRole)}
   */
  @Test
  @DisplayName("Test Builder role(AppGroupMemberRole)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.role(AppGroupMemberRole)"})
  void testBuilderRole() {
    // Arrange
    Builder builderResult = ImmutableAppGroupSubscription.builder();

    // Act
    Builder actualRoleResult = builderResult.role(AppGroupMemberRole.VIEWER);

    // Assert
    assertSame(builderResult, actualRoleResult);
  }

  /**
   * Test {@link ImmutableAppGroupSubscription#copyOf(AppGroupSubscription)}.
   *
   * <ul>
   *   <li>Then appGroup return {@link ImmutableAppGroup}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupSubscription#copyOf(AppGroupSubscription)}
   */
  @Test
  @DisplayName("Test copyOf(AppGroupSubscription); then appGroup return ImmutableAppGroup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupSubscription ImmutableAppGroupSubscription.copyOf(AppGroupSubscription)"
  })
  void testCopyOf_thenAppGroupReturnImmutableAppGroup() {
    // Arrange
    Builder builderResult = ImmutableAppGroupSubscription.builder();
    ImmutableAppGroupSubscription instance =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .role(AppGroupMemberRole.VIEWER)
            .build();

    // Act
    ImmutableAppGroupSubscription actualCopyOfResult =
        ImmutableAppGroupSubscription.copyOf(instance);

    // Assert
    AppGroup appGroupResult = actualCopyOfResult.appGroup();
    assertTrue(appGroupResult instanceof ImmutableAppGroup);
    assertEquals("Name", appGroupResult.name());
    assertEquals("The characteristics of someone or something", appGroupResult.description());
    assertEquals(EntityKind.ALL, appGroupResult.kind());
    assertEquals(AppGroupKind.PUBLIC, appGroupResult.appGroupKind());
    assertEquals(AppGroupMemberRole.VIEWER, actualCopyOfResult.role());
    assertFalse(appGroupResult.isRemoved());
    assertFalse(appGroupResult.isFavouriteGroup());
  }

  /**
   * Test {@link ImmutableAppGroupSubscription#equals(Object)}, and {@link
   * ImmutableAppGroupSubscription#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppGroupSubscription#equals(Object)}
   *   <li>{@link ImmutableAppGroupSubscription#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupSubscription.equals(Object)",
    "int ImmutableAppGroupSubscription.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAppGroupSubscription.builder();
    ImmutableAppGroupSubscription immutableAppGroupSubscription =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .role(AppGroupMemberRole.VIEWER)
            .build();

    Builder builderResult2 = ImmutableAppGroupSubscription.builder();
    ImmutableAppGroupSubscription immutableAppGroupSubscription2 =
        builderResult2
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .role(AppGroupMemberRole.VIEWER)
            .build();

    // Act and Assert
    assertEquals(immutableAppGroupSubscription, immutableAppGroupSubscription2);
    assertEquals(
        immutableAppGroupSubscription.hashCode(), immutableAppGroupSubscription2.hashCode());
  }

  /**
   * Test {@link ImmutableAppGroupSubscription#equals(Object)}, and {@link
   * ImmutableAppGroupSubscription#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppGroupSubscription#equals(Object)}
   *   <li>{@link ImmutableAppGroupSubscription#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupSubscription.equals(Object)",
    "int ImmutableAppGroupSubscription.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAppGroupSubscription.builder();
    ImmutableAppGroupSubscription immutableAppGroupSubscription =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .role(AppGroupMemberRole.VIEWER)
            .build();

    // Act and Assert
    assertEquals(immutableAppGroupSubscription, immutableAppGroupSubscription);
    int expectedHashCodeResult = immutableAppGroupSubscription.hashCode();
    assertEquals(expectedHashCodeResult, immutableAppGroupSubscription.hashCode());
  }

  /**
   * Test {@link ImmutableAppGroupSubscription#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupSubscription#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupSubscription.equals(Object)",
    "int ImmutableAppGroupSubscription.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAppGroupSubscription.builder();
    ImmutableAppGroupSubscription immutableAppGroupSubscription =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PRIVATE)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .role(AppGroupMemberRole.VIEWER)
            .build();

    Builder builderResult2 = ImmutableAppGroupSubscription.builder();

    // Act and Assert
    assertNotEquals(
        immutableAppGroupSubscription,
        builderResult2
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .role(AppGroupMemberRole.VIEWER)
            .build());
  }

  /**
   * Test {@link ImmutableAppGroupSubscription#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupSubscription#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupSubscription.equals(Object)",
    "int ImmutableAppGroupSubscription.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAppGroupSubscription.builder();
    ImmutableAppGroupSubscription immutableAppGroupSubscription =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .role(AppGroupMemberRole.OWNER)
            .build();

    Builder builderResult2 = ImmutableAppGroupSubscription.builder();

    // Act and Assert
    assertNotEquals(
        immutableAppGroupSubscription,
        builderResult2
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .role(AppGroupMemberRole.VIEWER)
            .build());
  }

  /**
   * Test {@link ImmutableAppGroupSubscription#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupSubscription#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupSubscription.equals(Object)",
    "int ImmutableAppGroupSubscription.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAppGroupSubscription.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .role(AppGroupMemberRole.VIEWER)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAppGroupSubscription#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupSubscription#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupSubscription.equals(Object)",
    "int ImmutableAppGroupSubscription.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAppGroupSubscription.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .role(AppGroupMemberRole.VIEWER)
            .build(),
        "Different type to ImmutableAppGroupSubscription");
  }

  /**
   * Test {@link ImmutableAppGroupSubscription#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link AppGroup}.
   *   <li>When {@link Json} (default constructor) AppGroup is {@link AppGroup}.
   *   <li>Then return role is {@code VIEWER}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupSubscription#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given AppGroup; when Json (default constructor) AppGroup is AppGroup; then return role is 'VIEWER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupSubscription ImmutableAppGroupSubscription.fromJson(Json)"})
  void testFromJson_givenAppGroup_whenJsonAppGroupIsAppGroup_thenReturnRoleIsViewer() {
    // Arrange
    Json json = new Json();
    json.setAppGroup(mock(AppGroup.class));
    json.setRole(AppGroupMemberRole.VIEWER);

    // Act
    ImmutableAppGroupSubscription actualFromJsonResult =
        ImmutableAppGroupSubscription.fromJson(json);

    // Assert
    assertEquals(AppGroupMemberRole.VIEWER, actualFromJsonResult.role());
    AppGroup expectedAppGroupResult = json.appGroup;
    assertSame(expectedAppGroupResult, actualFromJsonResult.appGroup());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppGroupSubscription#toString()}
   *   <li>{@link ImmutableAppGroupSubscription#appGroup()}
   *   <li>{@link ImmutableAppGroupSubscription#role()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AppGroup ImmutableAppGroupSubscription.appGroup()",
    "AppGroupMemberRole ImmutableAppGroupSubscription.role()",
    "String ImmutableAppGroupSubscription.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableAppGroupSubscription.builder();
    ImmutableAppGroupSubscription immutableAppGroupSubscription =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .role(AppGroupMemberRole.VIEWER)
            .build();

    // Act
    String actualToStringResult = immutableAppGroupSubscription.toString();
    AppGroup actualAppGroupResult = immutableAppGroupSubscription.appGroup();

    // Assert
    assertTrue(actualAppGroupResult instanceof ImmutableAppGroup);
    assertEquals(
        "AppGroupSubscription{appGroup=AppGroup{id=1, name=Name, externalId=42, isRemoved=false, appGroupKind=PUBLIC,"
            + " kind=ALL, isFavouriteGroup=false}, role=VIEWER}",
        actualToStringResult);
    assertEquals(AppGroupMemberRole.VIEWER, immutableAppGroupSubscription.role());
  }

  /**
   * Test Json {@link Json#appGroup()}.
   *
   * <p>Method under test: {@link Json#appGroup()}
   */
  @Test
  @DisplayName("Test Json appGroup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroup Json.appGroup()"})
  void testJsonAppGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().appGroup());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAppGroup(AppGroup)}
   *   <li>{@link Json#setRole(AppGroupMemberRole)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setAppGroup(AppGroup)",
    "void Json.setRole(AppGroupMemberRole)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAppGroup(
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setRole(AppGroupMemberRole.VIEWER);

    // Assert
    AppGroup appGroup = actualJson.appGroup;
    assertTrue(appGroup instanceof ImmutableAppGroup);
    assertEquals("Name", appGroup.name());
    assertEquals("The characteristics of someone or something", appGroup.description());
    assertEquals(EntityKind.ALL, appGroup.kind());
    assertEquals(AppGroupKind.PUBLIC, appGroup.appGroupKind());
    assertEquals(AppGroupMemberRole.VIEWER, actualJson.role);
    assertFalse(appGroup.isRemoved());
    assertFalse(appGroup.isFavouriteGroup());
  }

  /**
   * Test Json {@link Json#role()}.
   *
   * <p>Method under test: {@link Json#role()}
   */
  @Test
  @DisplayName("Test Json role()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupMemberRole Json.role()"})
  void testJsonRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().role());
  }

  /**
   * Test {@link ImmutableAppGroupSubscription#withAppGroup(AppGroup)}.
   *
   * <p>Method under test: {@link ImmutableAppGroupSubscription#withAppGroup(AppGroup)}
   */
  @Test
  @DisplayName("Test withAppGroup(AppGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupSubscription ImmutableAppGroupSubscription.withAppGroup(AppGroup)"
  })
  void testWithAppGroup() {
    // Arrange
    Builder builderResult = ImmutableAppGroupSubscription.builder();
    ImmutableAppGroupSubscription immutableAppGroupSubscription =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .role(AppGroupMemberRole.VIEWER)
            .build();

    // Act
    ImmutableAppGroupSubscription actualWithAppGroupResult =
        immutableAppGroupSubscription.withAppGroup(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableAppGroupSubscription, actualWithAppGroupResult);
  }

  /**
   * Test {@link ImmutableAppGroupSubscription#withRole(AppGroupMemberRole)}.
   *
   * <p>Method under test: {@link ImmutableAppGroupSubscription#withRole(AppGroupMemberRole)}
   */
  @Test
  @DisplayName("Test withRole(AppGroupMemberRole)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupSubscription ImmutableAppGroupSubscription.withRole(AppGroupMemberRole)"
  })
  void testWithRole() {
    // Arrange
    Builder builderResult = ImmutableAppGroupSubscription.builder();
    ImmutableAppGroupSubscription immutableAppGroupSubscription =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .role(AppGroupMemberRole.VIEWER)
            .build();

    // Act
    ImmutableAppGroupSubscription actualWithRoleResult =
        immutableAppGroupSubscription.withRole(AppGroupMemberRole.VIEWER);

    // Assert
    assertSame(immutableAppGroupSubscription, actualWithRoleResult);
  }

  /**
   * Test {@link ImmutableAppGroupSubscription#withRole(AppGroupMemberRole)}.
   *
   * <ul>
   *   <li>Then appGroup return {@link ImmutableAppGroup}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupSubscription#withRole(AppGroupMemberRole)}
   */
  @Test
  @DisplayName("Test withRole(AppGroupMemberRole); then appGroup return ImmutableAppGroup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupSubscription ImmutableAppGroupSubscription.withRole(AppGroupMemberRole)"
  })
  void testWithRole_thenAppGroupReturnImmutableAppGroup() {
    // Arrange
    Builder builderResult = ImmutableAppGroupSubscription.builder();

    // Act
    ImmutableAppGroupSubscription actualWithRoleResult =
        builderResult
            .appGroup(
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .role(AppGroupMemberRole.OWNER)
            .build()
            .withRole(AppGroupMemberRole.VIEWER);

    // Assert
    AppGroup appGroupResult = actualWithRoleResult.appGroup();
    assertTrue(appGroupResult instanceof ImmutableAppGroup);
    assertEquals("Name", appGroupResult.name());
    assertEquals("The characteristics of someone or something", appGroupResult.description());
    assertEquals(EntityKind.ALL, appGroupResult.kind());
    assertEquals(AppGroupKind.PUBLIC, appGroupResult.appGroupKind());
    assertEquals(AppGroupMemberRole.VIEWER, actualWithRoleResult.role());
    assertFalse(appGroupResult.isRemoved());
    assertFalse(appGroupResult.isFavouriteGroup());
  }
}
