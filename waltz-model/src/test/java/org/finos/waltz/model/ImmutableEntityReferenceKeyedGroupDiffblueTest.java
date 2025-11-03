package org.finos.waltz.model;

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
import org.finos.waltz.model.ImmutableEntityReference.Json;
import org.finos.waltz.model.ImmutableEntityReferenceKeyedGroup.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityReferenceKeyedGroupDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllValues(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllValues(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllValues(Iterable)"})
  void testBuilderAddAllValues_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllValues(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addValues(EntityReference)} with {@code element}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addValues(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder addValues(EntityReference) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addValues(EntityReference)"})
  void testBuilderAddValuesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addValues(new Json()));
  }

  /**
   * Test Builder {@link Builder#addValues(EntityReference[])} with {@code elements}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addValues(EntityReference[])}
   */
  @Test
  @DisplayName("Test Builder addValues(EntityReference[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addValues(EntityReference[])"})
  void testBuilderAddValuesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addValues(new Json()));
  }

  /**
   * Test Builder {@link Builder#from(EntityReferenceKeyedGroup)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Json} (default constructor).</li>
   *   <li>Then builder build values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityReferenceKeyedGroup)}
   */
  @Test
  @DisplayName("Test Builder from(EntityReferenceKeyedGroup); given ArrayList() add Json (default constructor); then builder build values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityReferenceKeyedGroup)"})
  void testBuilderFrom_givenArrayListAddJson_thenBuilderBuildValuesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    Json json = new Json();
    entityReferenceList.add(json);
    EntityReferenceKeyedGroup instance = mock(EntityReferenceKeyedGroup.class);
    when(instance.values()).thenReturn(entityReferenceList);
    when(instance.key()).thenReturn(new Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).key();
    verify(instance).values();
    List<EntityReference> valuesResult = builderResult.build().values();
    assertEquals(1, valuesResult.size());
    assertEquals(entityReferenceList, actualFromResult.build().values());
    assertSame(json, valuesResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(EntityReferenceKeyedGroup)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build key is {@link Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityReferenceKeyedGroup)}
   */
  @Test
  @DisplayName("Test Builder from(EntityReferenceKeyedGroup); given ArrayList(); then builder build key is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityReferenceKeyedGroup)"})
  void testBuilderFrom_givenArrayList_thenBuilderBuildKeyIsJson() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();
    EntityReferenceKeyedGroup instance = mock(EntityReferenceKeyedGroup.class);
    when(instance.values()).thenReturn(new ArrayList<>());
    Json json = new Json();
    when(instance.key()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).key();
    verify(instance).values();
    assertSame(json, builderResult.build().key());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityReferenceKeyedGroup)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityReferenceKeyedGroup)}
   */
  @Test
  @DisplayName("Test Builder from(EntityReferenceKeyedGroup); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityReferenceKeyedGroup)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();
    EntityReferenceKeyedGroup instance = mock(EntityReferenceKeyedGroup.class);
    when(instance.values()).thenThrow(new IllegalStateException("instance"));
    when(instance.key()).thenReturn(new Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).key();
    verify(instance).values();
  }

  /**
   * Test Builder {@link Builder#key(EntityReference)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then builder build key is {@link Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#key(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder key(EntityReference); when Json (default constructor); then builder build key is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.key(EntityReference)"})
  void testBuilderKey_whenJson_thenBuilderBuildKeyIsJson() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();
    Json key = new Json();

    // Act
    Builder actualKeyResult = builderResult.key(key);

    // Assert
    assertSame(key, builderResult.build().key());
    assertSame(builderResult, actualKeyResult);
  }

  /**
   * Test Builder {@link Builder#values(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#values(Iterable)}
   */
  @Test
  @DisplayName("Test Builder values(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.values(Iterable)"})
  void testBuilderValues_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.values(new ArrayList<>()));
  }

  /**
   * Test Json {@link ImmutableEntityReferenceKeyedGroup.Json#key()}.
   * <p>
   * Method under test: {@link ImmutableEntityReferenceKeyedGroup.Json#key()}
   */
  @Test
  @DisplayName("Test Json key()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference ImmutableEntityReferenceKeyedGroup.Json.key()"})
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityReferenceKeyedGroup.Json()).key());
  }

  /**
   * Test Json new {@link ImmutableEntityReferenceKeyedGroup.Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ImmutableEntityReferenceKeyedGroup.Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImmutableEntityReferenceKeyedGroup.Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntityReferenceKeyedGroup.Json actualJson = new ImmutableEntityReferenceKeyedGroup.Json();

    // Assert
    assertNull(actualJson.key);
    assertTrue(actualJson.values.isEmpty());
  }

  /**
   * Test Json {@link ImmutableEntityReferenceKeyedGroup.Json#values()}.
   * <p>
   * Method under test: {@link ImmutableEntityReferenceKeyedGroup.Json#values()}
   */
  @Test
  @DisplayName("Test Json values()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableEntityReferenceKeyedGroup.Json.values()"})
  void testJsonValues() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityReferenceKeyedGroup.Json()).values());
  }
}
