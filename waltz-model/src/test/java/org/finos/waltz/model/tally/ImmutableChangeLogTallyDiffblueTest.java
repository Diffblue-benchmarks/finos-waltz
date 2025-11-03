package org.finos.waltz.model.tally;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.tally.ImmutableChangeLogTally.Builder;
import org.finos.waltz.model.tally.ImmutableChangeLogTally.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableChangeLogTallyDiffblueTest {
  /**
   * Test {@link ImmutableChangeLogTally#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableChangeLogTally#builder()}
   *   <li>{@link ImmutableChangeLogTally#childKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableChangeLogTally Builder.build()", "Builder Builder.childKind(EntityKind)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableChangeLogTally.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.childKind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#count(long)}.
   * <p>
   * Method under test: {@link Builder#count(long)}
   */
  @Test
  @DisplayName("Test Builder count(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.count(long)"})
  void testBuilderCount() {
    // Arrange
    Builder builderResult = ImmutableChangeLogTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3L));
  }

  /**
   * Test Builder {@link Builder#from(ChangeLogTally)}.
   * <ul>
   *   <li>Given {@code ALL}.</li>
   *   <li>Then builder build childKind is {@code ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeLogTally)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeLogTally); given 'ALL'; then builder build childKind is 'ALL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeLogTally)"})
  void testBuilderFrom_givenAll_thenBuilderBuildChildKindIsAll() {
    // Arrange
    Builder builderResult = ImmutableChangeLogTally.builder();
    ChangeLogTally instance = mock(ChangeLogTally.class);
    when(instance.count()).thenReturn(3L);
    when(instance.childKind()).thenReturn(EntityKind.ALL);
    when(instance.ref()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).childKind();
    verify(instance).count();
    verify(instance).ref();
    ImmutableChangeLogTally buildResult = builderResult.build();
    assertEquals(3L, buildResult.count());
    assertEquals(EntityKind.ALL, buildResult.childKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeLogTally)}.
   * <ul>
   *   <li>Then builder build childKind is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeLogTally)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeLogTally); then builder build childKind is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeLogTally)"})
  void testBuilderFrom_thenBuilderBuildChildKindIsNull() {
    // Arrange
    Builder builderResult = ImmutableChangeLogTally.builder();
    ChangeLogTally instance = mock(ChangeLogTally.class);
    when(instance.count()).thenReturn(3L);
    when(instance.childKind()).thenReturn(null);
    when(instance.ref()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).childKind();
    verify(instance).count();
    verify(instance).ref();
    ImmutableChangeLogTally buildResult = builderResult.build();
    assertNull(buildResult.childKind());
    assertEquals(3L, buildResult.count());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeLogTally)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeLogTally)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeLogTally); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeLogTally)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeLogTally.builder();
    ChangeLogTally instance = mock(ChangeLogTally.class);
    when(instance.childKind()).thenThrow(new IllegalStateException("instance"));
    when(instance.ref()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).childKind();
    verify(instance).ref();
  }

  /**
   * Test Builder {@link Builder#ref(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ref(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder ref(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ref(EntityReference)"})
  void testBuilderRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeLogTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ref(mock(EntityReference.class)));
  }

  /**
   * Test Json {@link Json#childKind()}.
   * <p>
   * Method under test: {@link Json#childKind()}
   */
  @Test
  @DisplayName("Test Json childKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.childKind()"})
  void testJsonChildKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).childKind());
  }

  /**
   * Test Json {@link Json#count()}.
   * <p>
   * Method under test: {@link Json#count()}
   */
  @Test
  @DisplayName("Test Json count()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.count()"})
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).count());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setChildKind(EntityKind)}
   *   <li>{@link Json#setRef(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setChildKind(EntityKind)", "void Json.setRef(EntityReference)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setChildKind(EntityKind.ALL);
    actualJson.setRef(null);

    // Assert
    assertNull(actualJson.ref);
    assertEquals(0L, actualJson.count);
    assertEquals(EntityKind.ALL, actualJson.childKind);
    assertFalse(actualJson.countIsSet);
  }

  /**
   * Test Json {@link Json#ref()}.
   * <p>
   * Method under test: {@link Json#ref()}
   */
  @Test
  @DisplayName("Test Json ref()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.ref()"})
  void testJsonRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ref());
  }

  /**
   * Test Json {@link Json#setCount(long)}.
   * <p>
   * Method under test: {@link Json#setCount(long)}
   */
  @Test
  @DisplayName("Test Json setCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setCount(long)"})
  void testJsonSetCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCount(3L);

    // Assert
    assertEquals(3L, json.count);
    assertTrue(json.countIsSet);
  }
}
