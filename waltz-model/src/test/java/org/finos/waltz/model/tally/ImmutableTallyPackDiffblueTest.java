package org.finos.waltz.model.tally;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.tally.ImmutableTallyPack.Builder;
import org.finos.waltz.model.tally.ImmutableTallyPack.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTallyPackDiffblueTest {
  /**
   * Test {@link ImmutableTallyPack#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableTallyPack#builder()}
   *   <li>{@link ImmutableTallyPack#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableTallyPack Builder.build()", "Builder Builder.lastUpdatedAt(LocalDateTime)"})
  void testBuilder() {
    // Arrange and Act
    Builder<Object> actualBuilderResult = ImmutableTallyPack.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Test Builder {@link Builder#addAllTallies(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllTallies(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllTallies(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllTallies(Iterable)"})
  void testBuilderAddAllTallies_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllTallies(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addTallies(Tally)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableOrderedTally.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addTallies(Tally)}
   */
  @Test
  @DisplayName("Test Builder addTallies(Tally) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addTallies(Tally)"})
  void testBuilderAddTalliesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTallies(new ImmutableOrderedTally.Json<>()));
  }

  /**
   * Test Builder {@link Builder#addTallies(Tally[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableOrderedTally.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addTallies(Tally[])}
   */
  @Test
  @DisplayName("Test Builder addTallies(Tally[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addTallies(Tally[])"})
  void testBuilderAddTalliesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTallies(new ImmutableOrderedTally.Json<>()));
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();
    EntityReference entityReference = mock(EntityReference.class);

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(entityReference));
    assertSame(entityReference, builderResult.build().entityReference());
  }

  /**
   * Test Builder {@link Builder#from(TallyPack)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableOrderedTally.Json} (default constructor).</li>
   *   <li>Then builder build tallies size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TallyPack)}
   */
  @Test
  @DisplayName("Test Builder from(TallyPack); given ArrayList() add Json (default constructor); then builder build tallies size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TallyPack)"})
  void testBuilderFrom_givenArrayListAddJson_thenBuilderBuildTalliesSizeIsOne() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();

    ArrayList<Tally<Object>> tallyList = new ArrayList<>();
    ImmutableOrderedTally.Json<Object> json = new ImmutableOrderedTally.Json<>();
    tallyList.add(json);
    TallyPack<Object> instance = mock(TallyPack.class);
    when(instance.tallies()).thenReturn(tallyList);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).lastUpdatedAt();
    verify(instance).tallies();
    List<Tally<Object>> talliesResult = builderResult.build().tallies();
    assertEquals(1, talliesResult.size());
    assertEquals(tallyList, actualFromResult.build().tallies());
    assertSame(json, talliesResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(TallyPack)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TallyPack)}
   */
  @Test
  @DisplayName("Test Builder from(TallyPack); given ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TallyPack)"})
  void testBuilderFrom_givenArrayList_thenReturnBuilder() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();
    TallyPack<Object> instance = mock(TallyPack.class);
    when(instance.tallies()).thenReturn(new ArrayList<>());
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).lastUpdatedAt();
    verify(instance).tallies();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(TallyPack)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TallyPack)}
   */
  @Test
  @DisplayName("Test Builder from(TallyPack); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TallyPack)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();
    TallyPack<Object> instance = mock(TallyPack.class);
    when(instance.tallies()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
    verify(instance).tallies();
  }

  /**
   * Test Builder {@link Builder#tallies(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#tallies(Iterable)}
   */
  @Test
  @DisplayName("Test Builder tallies(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.tallies(Iterable)"})
  void testBuilderTallies_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.tallies(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.entityReference());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.lastUpdatedAt());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json<Object> actualJson = new Json<>();

    // Assert
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.entityReference);
    assertTrue(actualJson.tallies.isEmpty());
  }

  /**
   * Test Json {@link Json#tallies()}.
   * <p>
   * Method under test: {@link Json#tallies()}
   */
  @Test
  @DisplayName("Test Json tallies()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.tallies()"})
  void testJsonTallies() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.tallies());
  }
}
