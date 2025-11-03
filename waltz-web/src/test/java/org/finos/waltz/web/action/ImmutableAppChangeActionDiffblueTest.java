package org.finos.waltz.web.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.web.action.ImmutableAppChangeAction.Builder;
import org.finos.waltz.web.action.ImmutableAppChangeAction.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppChangeActionDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllChanges(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllChanges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChanges(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllChanges(Iterable)"})
  void testBuilderAddAllChanges_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChanges(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addChanges(FieldChange)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableFieldChange.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addChanges(FieldChange)}
   */
  @Test
  @DisplayName("Test Builder addChanges(FieldChange) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addChanges(FieldChange)"})
  void testBuilderAddChangesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChanges(new ImmutableFieldChange.Json()));
  }

  /**
   * Test Builder {@link Builder#addChanges(FieldChange[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableFieldChange.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addChanges(FieldChange[])}
   */
  @Test
  @DisplayName("Test Builder addChanges(FieldChange[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addChanges(FieldChange[])"})
  void testBuilderAddChangesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChanges(new ImmutableFieldChange.Json()));
  }

  /**
   * Test Builder {@link Builder#app(Application)}.
   * <ul>
   *   <li>When {@link Application}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#app(Application)}
   */
  @Test
  @DisplayName("Test Builder app(Application); when Application; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.app(Application)"})
  void testBuilderApp_whenApplication_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();
    Application app = mock(Application.class);

    // Act and Assert
    assertSame(builderResult, builderResult.app(app));
    assertSame(app, builderResult.build().app());
  }

  /**
   * Test Builder {@link Builder#changes(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#changes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder changes(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.changes(Iterable)"})
  void testBuilderChanges_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changes(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(AppChangeAction)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableFieldChange.Json} (default constructor).</li>
   *   <li>Then builder build changes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppChangeAction)}
   */
  @Test
  @DisplayName("Test Builder from(AppChangeAction); given ArrayList() add Json (default constructor); then builder build changes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppChangeAction)"})
  void testBuilderFrom_givenArrayListAddJson_thenBuilderBuildChangesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();

    ArrayList<FieldChange> fieldChangeList = new ArrayList<>();
    ImmutableFieldChange.Json json = new ImmutableFieldChange.Json();
    fieldChangeList.add(json);
    AppChangeAction instance = mock(AppChangeAction.class);
    when(instance.changes()).thenReturn(fieldChangeList);
    when(instance.app()).thenReturn(mock(Application.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).app();
    verify(instance).changes();
    List<FieldChange> changesResult = builderResult.build().changes();
    assertEquals(1, changesResult.size());
    assertEquals(fieldChangeList, actualFromResult.build().changes());
    assertSame(json, changesResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(AppChangeAction)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return build changes Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppChangeAction)}
   */
  @Test
  @DisplayName("Test Builder from(AppChangeAction); given ArrayList(); then return build changes Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppChangeAction)"})
  void testBuilderFrom_givenArrayList_thenReturnBuildChangesEmpty() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();
    AppChangeAction instance = mock(AppChangeAction.class);
    when(instance.changes()).thenReturn(new ArrayList<>());
    when(instance.app()).thenReturn(mock(Application.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).app();
    verify(instance).changes();
    assertTrue(actualFromResult.build().changes().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AppChangeAction)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppChangeAction)}
   */
  @Test
  @DisplayName("Test Builder from(AppChangeAction); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppChangeAction)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAppChangeAction.builder();
    AppChangeAction instance = mock(AppChangeAction.class);
    when(instance.changes()).thenThrow(new IllegalStateException("instance"));
    when(instance.app()).thenReturn(mock(Application.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).app();
    verify(instance).changes();
  }

  /**
   * Test Json {@link Json#app()}.
   * <p>
   * Method under test: {@link Json#app()}
   */
  @Test
  @DisplayName("Test Json app()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Application Json.app()"})
  void testJsonApp() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).app());
  }

  /**
   * Test Json {@link Json#changes()}.
   * <p>
   * Method under test: {@link Json#changes()}
   */
  @Test
  @DisplayName("Test Json changes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.changes()"})
  void testJsonChanges() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).changes());
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
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.app);
    assertTrue(actualJson.changes.isEmpty());
  }
}
