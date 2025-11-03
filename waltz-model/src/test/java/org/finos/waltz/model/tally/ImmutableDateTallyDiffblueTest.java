package org.finos.waltz.model.tally;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Date;
import org.finos.waltz.model.tally.ImmutableDateTally.Builder;
import org.finos.waltz.model.tally.ImmutableDateTally.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDateTallyDiffblueTest {
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
    Builder builderResult = ImmutableDateTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3L));
  }

  /**
   * Test Builder {@link Builder#date(Date)}.
   * <p>
   * Method under test: {@link Builder#date(Date)}
   */
  @Test
  @DisplayName("Test Builder date(Date)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.date(Date)"})
  void testBuilderDate() {
    // Arrange
    Builder builderResult = ImmutableDateTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.date(mock(Date.class)));
  }

  /**
   * Test Builder {@link Builder#from(DateTally)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then builder build count is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DateTally)}
   */
  @Test
  @DisplayName("Test Builder from(DateTally); given three; then builder build count is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DateTally)"})
  void testBuilderFrom_givenThree_thenBuilderBuildCountIsThree() {
    // Arrange
    Builder builderResult = ImmutableDateTally.builder();
    DateTally instance = mock(DateTally.class);
    when(instance.count()).thenReturn(3L);
    when(instance.date()).thenReturn(mock(Date.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).date();
    assertEquals(3L, builderResult.build().count());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DateTally)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DateTally)}
   */
  @Test
  @DisplayName("Test Builder from(DateTally); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DateTally)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDateTally.builder();
    DateTally instance = mock(DateTally.class);
    when(instance.count()).thenThrow(new IllegalStateException("instance"));
    when(instance.date()).thenReturn(mock(Date.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).count();
    verify(instance).date();
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
   * Test Json {@link Json#date()}.
   * <p>
   * Method under test: {@link Json#date()}
   */
  @Test
  @DisplayName("Test Json date()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Date Json.date()"})
  void testJsonDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).date());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDate(Date)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDate(Date)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDate(mock(Date.class));

    // Assert
    assertEquals(0L, actualJson.count);
    assertFalse(actualJson.countIsSet);
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
