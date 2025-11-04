package org.finos.waltz.web.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.application.Application;
import org.junit.jupiter.api.Test;

class ImmutableAppChangeActionDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAppChangeAction.Builder#addAllChanges(Iterable)}
   */
  @Test
  void testBuilderAddAllChanges() {
    // Arrange
    ImmutableAppChangeAction.Builder builderResult = ImmutableAppChangeAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChanges(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppChangeAction.Builder#addChanges(FieldChange)}
   */
  @Test
  void testBuilderAddChanges() {
    // Arrange
    ImmutableAppChangeAction.Builder builderResult = ImmutableAppChangeAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChanges(new ImmutableFieldChange.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppChangeAction.Builder#addChanges(FieldChange[])}
   */
  @Test
  void testBuilderAddChanges2() {
    // Arrange
    ImmutableAppChangeAction.Builder builderResult = ImmutableAppChangeAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChanges(new ImmutableFieldChange.Json()));
  }

  /**
   * Method under test: {@link ImmutableAppChangeAction.Builder#app(Application)}
   */
  @Test
  void testBuilderApp() {
    // Arrange
    ImmutableAppChangeAction.Builder builderResult = ImmutableAppChangeAction.builder();
    Application app = mock(Application.class);

    // Act and Assert
    assertSame(builderResult, builderResult.app(app));
    assertSame(app, builderResult.build().app());
  }

  /**
   * Method under test: {@link ImmutableAppChangeAction.Builder#changes(Iterable)}
   */
  @Test
  void testBuilderChanges() {
    // Arrange
    ImmutableAppChangeAction.Builder builderResult = ImmutableAppChangeAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changes(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppChangeAction.Builder#from(AppChangeAction)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAppChangeAction.Builder builderResult = ImmutableAppChangeAction.builder();
    AppChangeAction instance = mock(AppChangeAction.class);
    when(instance.changes()).thenReturn(new ArrayList<>());
    when(instance.app()).thenReturn(mock(Application.class));

    // Act
    ImmutableAppChangeAction.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).app();
    verify(instance).changes();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppChangeAction.Builder#from(AppChangeAction)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAppChangeAction.Builder builderResult = ImmutableAppChangeAction.builder();

    ArrayList<FieldChange> fieldChangeList = new ArrayList<>();
    ImmutableFieldChange.Json json = new ImmutableFieldChange.Json();
    fieldChangeList.add(json);
    AppChangeAction instance = mock(AppChangeAction.class);
    when(instance.changes()).thenReturn(fieldChangeList);
    when(instance.app()).thenReturn(mock(Application.class));

    // Act
    ImmutableAppChangeAction.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).app();
    verify(instance).changes();
    List<FieldChange> changesResult = builderResult.build().changes();
    assertEquals(1, changesResult.size());
    assertSame(json, changesResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppChangeAction.Builder#from(AppChangeAction)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAppChangeAction.Builder builderResult = ImmutableAppChangeAction.builder();
    AppChangeAction instance = mock(AppChangeAction.class);
    when(instance.changes()).thenThrow(new IllegalStateException("instance"));
    when(instance.app()).thenReturn(mock(Application.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).app();
    verify(instance).changes();
  }

  /**
   * Method under test: {@link ImmutableAppChangeAction#copyOf(AppChangeAction)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AppChangeAction instance = mock(AppChangeAction.class);
    when(instance.changes()).thenReturn(new ArrayList<>());
    when(instance.app()).thenReturn(mock(Application.class));

    // Act
    ImmutableAppChangeAction actualCopyOfResult = ImmutableAppChangeAction.copyOf(instance);

    // Assert
    verify(instance).app();
    verify(instance).changes();
    assertTrue(actualCopyOfResult.changes().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableAppChangeAction#copyOf(AppChangeAction)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<FieldChange> fieldChangeList = new ArrayList<>();
    fieldChangeList.add(new ImmutableFieldChange.Json());
    AppChangeAction instance = mock(AppChangeAction.class);
    when(instance.changes()).thenReturn(fieldChangeList);
    when(instance.app()).thenReturn(mock(Application.class));

    // Act
    ImmutableAppChangeAction actualCopyOfResult = ImmutableAppChangeAction.copyOf(instance);

    // Assert
    verify(instance).app();
    verify(instance).changes();
    assertEquals(fieldChangeList, actualCopyOfResult.changes());
  }

  /**
   * Method under test: {@link ImmutableAppChangeAction#copyOf(AppChangeAction)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<FieldChange> fieldChangeList = new ArrayList<>();
    fieldChangeList.add(new ImmutableFieldChange.Json());
    fieldChangeList.add(new ImmutableFieldChange.Json());
    AppChangeAction instance = mock(AppChangeAction.class);
    when(instance.changes()).thenReturn(fieldChangeList);
    when(instance.app()).thenReturn(mock(Application.class));

    // Act
    ImmutableAppChangeAction actualCopyOfResult = ImmutableAppChangeAction.copyOf(instance);

    // Assert
    verify(instance).app();
    verify(instance).changes();
    assertEquals(fieldChangeList, actualCopyOfResult.changes());
  }

  /**
   * Method under test:
   * {@link ImmutableAppChangeAction#fromJson(ImmutableAppChangeAction.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAppChangeAction.Json json = new ImmutableAppChangeAction.Json();
    json.setApp(mock(Application.class));

    // Act
    ImmutableAppChangeAction actualFromJsonResult = ImmutableAppChangeAction.fromJson(json);

    // Assert
    List<FieldChange> changesResult = actualFromJsonResult.changes();
    assertTrue(changesResult.isEmpty());
    Application expectedAppResult = json.app;
    assertSame(expectedAppResult, actualFromJsonResult.app());
    assertSame(json.changes, changesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppChangeAction#fromJson(ImmutableAppChangeAction.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<FieldChange> changes = new ArrayList<>();
    changes.add(new ImmutableFieldChange.Json());

    ImmutableAppChangeAction.Json json = new ImmutableAppChangeAction.Json();
    json.setApp(mock(Application.class));
    json.setChanges(changes);

    // Act
    ImmutableAppChangeAction actualFromJsonResult = ImmutableAppChangeAction.fromJson(json);

    // Assert
    assertEquals(changes, actualFromJsonResult.changes());
    Application expectedAppResult = json.app;
    assertSame(expectedAppResult, actualFromJsonResult.app());
  }

  /**
   * Method under test:
   * {@link ImmutableAppChangeAction#fromJson(ImmutableAppChangeAction.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<FieldChange> changes = new ArrayList<>();
    changes.add(new ImmutableFieldChange.Json());
    changes.add(new ImmutableFieldChange.Json());

    ImmutableAppChangeAction.Json json = new ImmutableAppChangeAction.Json();
    json.setApp(mock(Application.class));
    json.setChanges(changes);

    // Act
    ImmutableAppChangeAction actualFromJsonResult = ImmutableAppChangeAction.fromJson(json);

    // Assert
    assertEquals(changes, actualFromJsonResult.changes());
    Application expectedAppResult = json.app;
    assertSame(expectedAppResult, actualFromJsonResult.app());
  }

  /**
   * Method under test: {@link ImmutableAppChangeAction.Json#app()}
   */
  @Test
  void testJsonApp() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppChangeAction.Json()).app());
  }

  /**
   * Method under test: {@link ImmutableAppChangeAction.Json#changes()}
   */
  @Test
  void testJsonChanges() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppChangeAction.Json()).changes());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAppChangeAction.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAppChangeAction.Json actualJson = new ImmutableAppChangeAction.Json();

    // Assert
    assertNull(actualJson.app);
    assertTrue(actualJson.changes.isEmpty());
  }
}
