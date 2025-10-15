package org.finos.waltz.data.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AppGroupHelperDiffblueTest {
  /**
   * Test {@link AppGroupHelper#processAdditionsAndRemovals(DSLContext, Set, Set, String)}.
   *
   * <p>Method under test: {@link AppGroupHelper#processAdditionsAndRemovals(DSLContext, Set, Set,
   * String)}
   */
  @Test
  @DisplayName("Test processAdditionsAndRemovals(DSLContext, Set, Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AppGroupHelper.processAdditionsAndRemovals(DSLContext, Set, Set, String)"
  })
  void testProcessAdditionsAndRemovals() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);

    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<Long, EntityReference> tuple2 = new Tuple2<>(1L, immutableEntityReference);
    additions.add(tuple2);

    // Act
    int actualProcessAdditionsAndRemovalsResult =
        AppGroupHelper.processAdditionsAndRemovals(dsl, additions, new HashSet<>(), "42");

    // Assert
    assertEquals(0, actualProcessAdditionsAndRemovalsResult);
  }

  /**
   * Test {@link AppGroupHelper#processAdditionsAndRemovals(DSLContext, Set, Set, String)}.
   *
   * <p>Method under test: {@link AppGroupHelper#processAdditionsAndRemovals(DSLContext, Set, Set,
   * String)}
   */
  @Test
  @DisplayName("Test processAdditionsAndRemovals(DSLContext, Set, Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AppGroupHelper.processAdditionsAndRemovals(DSLContext, Set, Set, String)"
  })
  void testProcessAdditionsAndRemovals2() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();

    HashSet<Tuple2<Long, EntityReference>> removals = new HashSet<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<Long, EntityReference> tuple2 = new Tuple2<>(1L, immutableEntityReference);
    removals.add(tuple2);

    // Act
    int actualProcessAdditionsAndRemovalsResult =
        AppGroupHelper.processAdditionsAndRemovals(dsl, additions, removals, "42");

    // Assert
    assertEquals(0, actualProcessAdditionsAndRemovalsResult);
  }

  /**
   * Test {@link AppGroupHelper#processAdditionsAndRemovals(DSLContext, Set, Set, String)}.
   *
   * <p>Method under test: {@link AppGroupHelper#processAdditionsAndRemovals(DSLContext, Set, Set,
   * String)}
   */
  @Test
  @DisplayName("Test processAdditionsAndRemovals(DSLContext, Set, Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AppGroupHelper.processAdditionsAndRemovals(DSLContext, Set, Set, String)"
  })
  void testProcessAdditionsAndRemovals3() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);

    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<Long, EntityReference> tuple2 = new Tuple2<>(-1L, immutableEntityReference);
    additions.add(tuple2);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<Long, EntityReference> tuple22 = new Tuple2<>(1L, immutableEntityReference2);
    additions.add(tuple22);

    // Act
    int actualProcessAdditionsAndRemovalsResult =
        AppGroupHelper.processAdditionsAndRemovals(dsl, additions, new HashSet<>(), "42");

    // Assert
    assertEquals(0, actualProcessAdditionsAndRemovalsResult);
  }

  /**
   * Test {@link AppGroupHelper#processAdditionsAndRemovals(DSLContext, Set, Set, String)}.
   *
   * <p>Method under test: {@link AppGroupHelper#processAdditionsAndRemovals(DSLContext, Set, Set,
   * String)}
   */
  @Test
  @DisplayName("Test processAdditionsAndRemovals(DSLContext, Set, Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AppGroupHelper.processAdditionsAndRemovals(DSLContext, Set, Set, String)"
  })
  void testProcessAdditionsAndRemovals4() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();

    HashSet<Tuple2<Long, EntityReference>> removals = new HashSet<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<Long, EntityReference> tuple2 = new Tuple2<>(-1L, immutableEntityReference);
    removals.add(tuple2);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<Long, EntityReference> tuple22 = new Tuple2<>(1L, immutableEntityReference2);
    removals.add(tuple22);

    // Act
    int actualProcessAdditionsAndRemovalsResult =
        AppGroupHelper.processAdditionsAndRemovals(dsl, additions, removals, "42");

    // Assert
    assertEquals(0, actualProcessAdditionsAndRemovalsResult);
  }

  /**
   * Test {@link AppGroupHelper#processAdditionsAndRemovals(DSLContext, Set, Set, String)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupHelper#processAdditionsAndRemovals(DSLContext, Set, Set,
   * String)}
   */
  @Test
  @DisplayName(
      "Test processAdditionsAndRemovals(DSLContext, Set, Set, String); when HashSet(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AppGroupHelper.processAdditionsAndRemovals(DSLContext, Set, Set, String)"
  })
  void testProcessAdditionsAndRemovals_whenHashSet_thenReturnZero() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();

    // Act
    int actualProcessAdditionsAndRemovalsResult =
        AppGroupHelper.processAdditionsAndRemovals(dsl, additions, new HashSet<>(), "42");

    // Assert
    assertEquals(0, actualProcessAdditionsAndRemovalsResult);
  }
}
