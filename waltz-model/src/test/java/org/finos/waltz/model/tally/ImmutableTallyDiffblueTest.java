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
import org.finos.waltz.model.tally.ImmutableTally.Builder;
import org.finos.waltz.model.tally.ImmutableTally.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTallyDiffblueTest {
  /**
   * Test Builder {@link Builder#count(double)}.
   * <p>
   * Method under test: {@link Builder#count(double)}
   */
  @Test
  @DisplayName("Test Builder count(double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.count(double)"})
  void testBuilderCount() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(10.0d));
  }

  /**
   * Test Builder {@link Builder#from(Tally)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link Tally} {@link Tally#count()} return ten.</li>
   *   <li>Then builder build id is {@code Id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Tally)}
   */
  @Test
  @DisplayName("Test Builder from(Tally); given ten; when Tally count() return ten; then builder build id is 'Id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Tally)"})
  void testBuilderFrom_givenTen_whenTallyCountReturnTen_thenBuilderBuildIdIsId() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();
    Tally<Object> instance = mock(Tally.class);
    when(instance.count()).thenReturn(10.0d);
    when(instance.id()).thenReturn("Id");

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).id();
    ImmutableTally<Object> buildResult = builderResult.build();
    assertEquals("Id", buildResult.id());
    assertEquals(10.0d, buildResult.count());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Tally)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Tally)}
   */
  @Test
  @DisplayName("Test Builder from(Tally); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Tally)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();
    Tally<Object> instance = mock(Tally.class);
    when(instance.count()).thenThrow(new IllegalStateException("instance"));
    when(instance.id()).thenReturn("Id");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).count();
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#id(Object)}.
   * <p>
   * Method under test: {@link Builder#id(Object)}
   */
  @Test
  @DisplayName("Test Builder id(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Object)"})
  void testBuilderId() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id("Id"));
  }

  /**
   * Test Json {@link Json#count()}.
   * <p>
   * Method under test: {@link Json#count()}
   */
  @Test
  @DisplayName("Test Json count()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Json.count()"})
  void testJsonCount() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.count());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setId(Object)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setId(Object)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json<Object> actualJson = new Json<>();
    actualJson.setId("Id");

    // Assert
    assertEquals("Id", actualJson.id);
    assertEquals(0.0d, actualJson.count);
    assertFalse(actualJson.countIsSet);
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Json.id()"})
  void testJsonId() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.id());
  }

  /**
   * Test Json {@link Json#setCount(double)}.
   * <p>
   * Method under test: {@link Json#setCount(double)}
   */
  @Test
  @DisplayName("Test Json setCount(double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setCount(double)"})
  void testJsonSetCount() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act
    json.setCount(10.0d);

    // Assert
    assertEquals(10.0d, json.count);
    assertTrue(json.countIsSet);
  }
}
