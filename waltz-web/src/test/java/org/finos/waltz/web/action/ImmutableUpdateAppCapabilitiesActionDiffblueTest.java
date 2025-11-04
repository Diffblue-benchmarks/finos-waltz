package org.finos.waltz.web.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableUpdateAppCapabilitiesActionDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction.Builder#addAdditions(EntityReference)}
   */
  @Test
  void testBuilderAddAdditions() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction.Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();
    EntityReference element = mock(EntityReference.class);

    // Act
    ImmutableUpdateAppCapabilitiesAction.Builder actualAddAdditionsResult = builderResult.addAdditions(element);

    // Assert
    List<EntityReference> additionsResult = builderResult.build().additions();
    assertEquals(1, additionsResult.size());
    assertSame(builderResult, actualAddAdditionsResult);
    assertSame(element, additionsResult.get(0));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction.Builder#addAdditions(EntityReference[])}
   */
  @Test
  void testBuilderAddAdditions2() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction.Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    // Act
    ImmutableUpdateAppCapabilitiesAction.Builder actualAddAdditionsResult = builderResult
        .addAdditions(mock(EntityReference.class));

    // Assert
    assertEquals(1, builderResult.build().additions().size());
    assertSame(builderResult, actualAddAdditionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction.Builder#addAllAdditions(Iterable)}
   */
  @Test
  void testBuilderAddAllAdditions() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction.Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAdditions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction.Builder#addAllRemovals(Iterable)}
   */
  @Test
  void testBuilderAddAllRemovals() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction.Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRemovals(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction.Builder#addRemovals(EntityReference)}
   */
  @Test
  void testBuilderAddRemovals() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction.Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();
    EntityReference element = mock(EntityReference.class);

    // Act
    ImmutableUpdateAppCapabilitiesAction.Builder actualAddRemovalsResult = builderResult.addRemovals(element);

    // Assert
    List<EntityReference> removalsResult = builderResult.build().removals();
    assertEquals(1, removalsResult.size());
    assertSame(builderResult, actualAddRemovalsResult);
    assertSame(element, removalsResult.get(0));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction.Builder#addRemovals(EntityReference[])}
   */
  @Test
  void testBuilderAddRemovals2() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction.Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    // Act
    ImmutableUpdateAppCapabilitiesAction.Builder actualAddRemovalsResult = builderResult
        .addRemovals(mock(EntityReference.class));

    // Assert
    assertEquals(1, builderResult.build().removals().size());
    assertSame(builderResult, actualAddRemovalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction.Builder#additions(Iterable)}
   */
  @Test
  void testBuilderAdditions() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction.Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.additions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableUpdateAppCapabilitiesAction.builder().build().additions().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction.Builder#from(UpdateAppCapabilitiesAction)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction.Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();
    UpdateAppCapabilitiesAction instance = mock(UpdateAppCapabilitiesAction.class);
    when(instance.additions()).thenReturn(new ArrayList<>());
    when(instance.removals()).thenReturn(new ArrayList<>());

    // Act
    ImmutableUpdateAppCapabilitiesAction.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).additions();
    verify(instance).removals();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction.Builder#from(UpdateAppCapabilitiesAction)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction.Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(mock(EntityReference.class));
    UpdateAppCapabilitiesAction instance = mock(UpdateAppCapabilitiesAction.class);
    when(instance.additions()).thenReturn(entityReferenceList);
    when(instance.removals()).thenReturn(new ArrayList<>());

    // Act
    ImmutableUpdateAppCapabilitiesAction.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).additions();
    verify(instance).removals();
    assertEquals(1, builderResult.build().additions().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction.Builder#from(UpdateAppCapabilitiesAction)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction.Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(mock(EntityReference.class));
    UpdateAppCapabilitiesAction instance = mock(UpdateAppCapabilitiesAction.class);
    when(instance.additions()).thenReturn(new ArrayList<>());
    when(instance.removals()).thenReturn(entityReferenceList);

    // Act
    ImmutableUpdateAppCapabilitiesAction.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).additions();
    verify(instance).removals();
    assertEquals(1, builderResult.build().removals().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction.Builder#removals(Iterable)}
   */
  @Test
  void testBuilderRemovals() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction.Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.removals(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction#copyOf(UpdateAppCapabilitiesAction)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UpdateAppCapabilitiesAction instance = mock(UpdateAppCapabilitiesAction.class);
    when(instance.additions()).thenReturn(new ArrayList<>());
    when(instance.removals()).thenReturn(new ArrayList<>());

    // Act
    ImmutableUpdateAppCapabilitiesAction actualCopyOfResult = ImmutableUpdateAppCapabilitiesAction.copyOf(instance);

    // Assert
    verify(instance).additions();
    verify(instance).removals();
    List<EntityReference> additionsResult = actualCopyOfResult.additions();
    assertTrue(additionsResult.isEmpty());
    assertSame(additionsResult, actualCopyOfResult.removals());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction#copyOf(UpdateAppCapabilitiesAction)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(mock(EntityReference.class));
    UpdateAppCapabilitiesAction instance = mock(UpdateAppCapabilitiesAction.class);
    when(instance.additions()).thenReturn(entityReferenceList);
    when(instance.removals()).thenReturn(new ArrayList<>());

    // Act
    ImmutableUpdateAppCapabilitiesAction actualCopyOfResult = ImmutableUpdateAppCapabilitiesAction.copyOf(instance);

    // Assert
    verify(instance).additions();
    verify(instance).removals();
    assertEquals(1, actualCopyOfResult.additions().size());
    assertTrue(actualCopyOfResult.removals().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction#copyOf(UpdateAppCapabilitiesAction)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(mock(EntityReference.class));
    entityReferenceList.add(mock(EntityReference.class));
    UpdateAppCapabilitiesAction instance = mock(UpdateAppCapabilitiesAction.class);
    when(instance.additions()).thenReturn(entityReferenceList);
    when(instance.removals()).thenReturn(new ArrayList<>());

    // Act
    ImmutableUpdateAppCapabilitiesAction actualCopyOfResult = ImmutableUpdateAppCapabilitiesAction.copyOf(instance);

    // Assert
    verify(instance).additions();
    verify(instance).removals();
    assertTrue(actualCopyOfResult.removals().isEmpty());
    assertEquals(entityReferenceList, actualCopyOfResult.additions());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction#copyOf(UpdateAppCapabilitiesAction)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(mock(EntityReference.class));
    UpdateAppCapabilitiesAction instance = mock(UpdateAppCapabilitiesAction.class);
    when(instance.additions()).thenReturn(new ArrayList<>());
    when(instance.removals()).thenReturn(entityReferenceList);

    // Act
    ImmutableUpdateAppCapabilitiesAction actualCopyOfResult = ImmutableUpdateAppCapabilitiesAction.copyOf(instance);

    // Assert
    verify(instance).additions();
    verify(instance).removals();
    assertEquals(1, actualCopyOfResult.removals().size());
    assertTrue(actualCopyOfResult.additions().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction#fromJson(ImmutableUpdateAppCapabilitiesAction.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction.Json json = new ImmutableUpdateAppCapabilitiesAction.Json();

    // Act
    ImmutableUpdateAppCapabilitiesAction actualFromJsonResult = ImmutableUpdateAppCapabilitiesAction.fromJson(json);

    // Assert
    List<EntityReference> additionsResult = actualFromJsonResult.additions();
    assertTrue(additionsResult.isEmpty());
    List<EntityReference> entityReferenceList = json.removals;
    assertSame(entityReferenceList, additionsResult);
    assertSame(entityReferenceList, actualFromJsonResult.removals());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction#fromJson(ImmutableUpdateAppCapabilitiesAction.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction.Json json = new ImmutableUpdateAppCapabilitiesAction.Json();
    json.setAdditions(null);
    json.setRemovals(null);

    // Act
    ImmutableUpdateAppCapabilitiesAction actualFromJsonResult = ImmutableUpdateAppCapabilitiesAction.fromJson(json);

    // Assert
    List<EntityReference> additionsResult = actualFromJsonResult.additions();
    assertTrue(additionsResult.isEmpty());
    assertSame(additionsResult, actualFromJsonResult.removals());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction#fromJson(ImmutableUpdateAppCapabilitiesAction.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<EntityReference> removals = new ArrayList<>();
    removals.add(mock(EntityReference.class));

    ImmutableUpdateAppCapabilitiesAction.Json json = new ImmutableUpdateAppCapabilitiesAction.Json();
    json.setAdditions(null);
    json.setRemovals(removals);

    // Act
    ImmutableUpdateAppCapabilitiesAction actualFromJsonResult = ImmutableUpdateAppCapabilitiesAction.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.removals().size());
    assertTrue(actualFromJsonResult.additions().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction#fromJson(ImmutableUpdateAppCapabilitiesAction.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ArrayList<EntityReference> additions = new ArrayList<>();
    additions.add(mock(EntityReference.class));

    ImmutableUpdateAppCapabilitiesAction.Json json = new ImmutableUpdateAppCapabilitiesAction.Json();
    json.setAdditions(additions);
    json.setRemovals(null);

    // Act
    ImmutableUpdateAppCapabilitiesAction actualFromJsonResult = ImmutableUpdateAppCapabilitiesAction.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.additions().size());
    assertTrue(actualFromJsonResult.removals().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction.Json#additions()}
   */
  @Test
  void testJsonAdditions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUpdateAppCapabilitiesAction.Json()).additions());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableUpdateAppCapabilitiesAction.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableUpdateAppCapabilitiesAction.Json actualJson = new ImmutableUpdateAppCapabilitiesAction.Json();

    // Assert
    assertTrue(actualJson.additions.isEmpty());
    assertTrue(actualJson.removals.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateAppCapabilitiesAction.Json#removals()}
   */
  @Test
  void testJsonRemovals() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUpdateAppCapabilitiesAction.Json()).removals());
  }
}
