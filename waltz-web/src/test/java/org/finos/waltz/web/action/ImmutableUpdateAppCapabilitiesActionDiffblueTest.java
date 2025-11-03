package org.finos.waltz.web.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.web.action.ImmutableUpdateAppCapabilitiesAction.Builder;
import org.finos.waltz.web.action.ImmutableUpdateAppCapabilitiesAction.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateAppCapabilitiesActionDiffblueTest {
  /**
   * Test Builder {@link Builder#addAdditions(EntityReference)} with {@code element}.
   * <ul>
   *   <li>Then builder build additions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAdditions(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder addAdditions(EntityReference) with 'element'; then builder build additions size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAdditions(EntityReference)"})
  void testBuilderAddAdditionsWithElement_thenBuilderBuildAdditionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();
    EntityReference element = mock(EntityReference.class);

    // Act
    Builder actualAddAdditionsResult = builderResult.addAdditions(element);

    // Assert
    List<EntityReference> additionsResult = builderResult.build().additions();
    assertEquals(1, additionsResult.size());
    assertSame(builderResult, actualAddAdditionsResult);
    assertSame(element, additionsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#addAdditions(EntityReference[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build additions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAdditions(EntityReference[])}
   */
  @Test
  @DisplayName("Test Builder addAdditions(EntityReference[]) with 'elements'; then builder build additions size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAdditions(EntityReference[])"})
  void testBuilderAddAdditionsWithElements_thenBuilderBuildAdditionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    // Act
    Builder actualAddAdditionsResult = builderResult.addAdditions(mock(EntityReference.class));

    // Assert
    assertEquals(1, builderResult.build().additions().size());
    assertSame(builderResult, actualAddAdditionsResult);
  }

  /**
   * Test Builder {@link Builder#addAllAdditions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAdditions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAdditions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAdditions(Iterable)"})
  void testBuilderAddAllAdditions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAdditions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllRemovals(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRemovals(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRemovals(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRemovals(Iterable)"})
  void testBuilderAddAllRemovals_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRemovals(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addRemovals(EntityReference)} with {@code element}.
   * <ul>
   *   <li>Then builder build removals size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRemovals(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder addRemovals(EntityReference) with 'element'; then builder build removals size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRemovals(EntityReference)"})
  void testBuilderAddRemovalsWithElement_thenBuilderBuildRemovalsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();
    EntityReference element = mock(EntityReference.class);

    // Act
    Builder actualAddRemovalsResult = builderResult.addRemovals(element);

    // Assert
    List<EntityReference> removalsResult = builderResult.build().removals();
    assertEquals(1, removalsResult.size());
    assertSame(builderResult, actualAddRemovalsResult);
    assertSame(element, removalsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#addRemovals(EntityReference[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build removals size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRemovals(EntityReference[])}
   */
  @Test
  @DisplayName("Test Builder addRemovals(EntityReference[]) with 'elements'; then builder build removals size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRemovals(EntityReference[])"})
  void testBuilderAddRemovalsWithElements_thenBuilderBuildRemovalsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    // Act
    Builder actualAddRemovalsResult = builderResult.addRemovals(mock(EntityReference.class));

    // Assert
    assertEquals(1, builderResult.build().removals().size());
    assertSame(builderResult, actualAddRemovalsResult);
  }

  /**
   * Test Builder {@link Builder#additions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#additions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder additions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.additions(Iterable)"})
  void testBuilderAdditions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.additions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateAppCapabilitiesAction Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableUpdateAppCapabilitiesAction.builder().build().additions().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(UpdateAppCapabilitiesAction)}.
   * <ul>
   *   <li>Then return build is builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateAppCapabilitiesAction)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateAppCapabilitiesAction); then return build is builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateAppCapabilitiesAction)"})
  void testBuilderFrom_thenReturnBuildIsBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();
    Builder builderResult2 = ImmutableUpdateAppCapabilitiesAction.builder();
    builderResult2.addAdditions(mock(EntityReference.class));
    ImmutableUpdateAppCapabilitiesAction instance = builderResult2.build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(UpdateAppCapabilitiesAction)}.
   * <ul>
   *   <li>When builder addRemovals {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateAppCapabilitiesAction)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateAppCapabilitiesAction); when builder addRemovals EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateAppCapabilitiesAction)"})
  void testBuilderFrom_whenBuilderAddRemovalsEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();
    Builder builderResult2 = ImmutableUpdateAppCapabilitiesAction.builder();
    builderResult2.addRemovals(mock(EntityReference.class));
    builderResult2.addAdditions(mock(EntityReference.class));
    ImmutableUpdateAppCapabilitiesAction instance = builderResult2.build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateAppCapabilitiesAction)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return build is builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateAppCapabilitiesAction)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateAppCapabilitiesAction); when builder build; then return build is builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateAppCapabilitiesAction)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildIsBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();
    ImmutableUpdateAppCapabilitiesAction instance = ImmutableUpdateAppCapabilitiesAction.builder().build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#removals(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#removals(Iterable)}
   */
  @Test
  @DisplayName("Test Builder removals(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.removals(Iterable)"})
  void testBuilderRemovals_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.removals(new ArrayList<>()));
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#copyOf(UpdateAppCapabilitiesAction)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return additions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateAppCapabilitiesAction#copyOf(UpdateAppCapabilitiesAction)}
   */
  @Test
  @DisplayName("Test copyOf(UpdateAppCapabilitiesAction); when builder build; then return additions Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableUpdateAppCapabilitiesAction ImmutableUpdateAppCapabilitiesAction.copyOf(UpdateAppCapabilitiesAction)"})
  void testCopyOf_whenBuilderBuild_thenReturnAdditionsEmpty() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction instance = ImmutableUpdateAppCapabilitiesAction.builder().build();

    // Act
    ImmutableUpdateAppCapabilitiesAction actualCopyOfResult = ImmutableUpdateAppCapabilitiesAction.copyOf(instance);

    // Assert
    List<EntityReference> additionsResult = actualCopyOfResult.additions();
    assertTrue(additionsResult.isEmpty());
    assertSame(additionsResult, actualCopyOfResult.removals());
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}, and {@link ImmutableUpdateAppCapabilitiesAction#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}
   *   <li>{@link ImmutableUpdateAppCapabilitiesAction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableUpdateAppCapabilitiesAction.equals(Object)",
      "int ImmutableUpdateAppCapabilitiesAction.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction buildResult = ImmutableUpdateAppCapabilitiesAction.builder().build();
    ImmutableUpdateAppCapabilitiesAction buildResult2 = ImmutableUpdateAppCapabilitiesAction.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}, and {@link ImmutableUpdateAppCapabilitiesAction#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}
   *   <li>{@link ImmutableUpdateAppCapabilitiesAction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableUpdateAppCapabilitiesAction.equals(Object)",
      "int ImmutableUpdateAppCapabilitiesAction.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction buildResult = ImmutableUpdateAppCapabilitiesAction.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableUpdateAppCapabilitiesAction.equals(Object)",
      "int ImmutableUpdateAppCapabilitiesAction.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();
    builderResult.addAdditions(mock(EntityReference.class));
    ImmutableUpdateAppCapabilitiesAction buildResult = builderResult.build();
    ImmutableUpdateAppCapabilitiesAction buildResult2 = ImmutableUpdateAppCapabilitiesAction.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableUpdateAppCapabilitiesAction.equals(Object)",
      "int ImmutableUpdateAppCapabilitiesAction.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();
    builderResult.addRemovals(mock(EntityReference.class));
    ImmutableUpdateAppCapabilitiesAction buildResult = builderResult.build();
    ImmutableUpdateAppCapabilitiesAction buildResult2 = ImmutableUpdateAppCapabilitiesAction.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableUpdateAppCapabilitiesAction.equals(Object)",
      "int ImmutableUpdateAppCapabilitiesAction.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction buildResult = ImmutableUpdateAppCapabilitiesAction.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableUpdateAppCapabilitiesAction.equals(Object)",
      "int ImmutableUpdateAppCapabilitiesAction.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction buildResult = ImmutableUpdateAppCapabilitiesAction.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableUpdateAppCapabilitiesAction");
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link EntityReference}.</li>
   *   <li>Then return additions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateAppCapabilitiesAction#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add EntityReference; then return additions size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateAppCapabilitiesAction ImmutableUpdateAppCapabilitiesAction.fromJson(Json)"})
  void testFromJson_givenArrayListAddEntityReference_thenReturnAdditionsSizeIsOne() {
    // Arrange
    ArrayList<EntityReference> additions = new ArrayList<>();
    additions.add(mock(EntityReference.class));

    Json json = new Json();
    json.setAdditions(additions);
    json.setRemovals(null);

    // Act
    ImmutableUpdateAppCapabilitiesAction actualFromJsonResult = ImmutableUpdateAppCapabilitiesAction.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.additions().size());
    assertTrue(actualFromJsonResult.removals().isEmpty());
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link EntityReference}.</li>
   *   <li>Then return removals size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateAppCapabilitiesAction#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add EntityReference; then return removals size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateAppCapabilitiesAction ImmutableUpdateAppCapabilitiesAction.fromJson(Json)"})
  void testFromJson_givenArrayListAddEntityReference_thenReturnRemovalsSizeIsOne() {
    // Arrange
    ArrayList<EntityReference> removals = new ArrayList<>();
    removals.add(mock(EntityReference.class));

    Json json = new Json();
    json.setAdditions(null);
    json.setRemovals(removals);

    // Act
    ImmutableUpdateAppCapabilitiesAction actualFromJsonResult = ImmutableUpdateAppCapabilitiesAction.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.removals().size());
    assertTrue(actualFromJsonResult.additions().isEmpty());
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) Additions is {@code null}.</li>
   *   <li>Then return removals is additions.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateAppCapabilitiesAction#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) Additions is 'null'; then return removals is additions")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateAppCapabilitiesAction ImmutableUpdateAppCapabilitiesAction.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonAdditionsIsNull_thenReturnRemovalsIsAdditions() {
    // Arrange
    Json json = new Json();
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
   * Test {@link ImmutableUpdateAppCapabilitiesAction#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return removals is {@link Json} (default constructor) {@link Json#removals}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateAppCapabilitiesAction#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return removals is Json (default constructor) removals")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateAppCapabilitiesAction ImmutableUpdateAppCapabilitiesAction.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnRemovalsIsJsonRemovals() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableUpdateAppCapabilitiesAction actualFromJsonResult = ImmutableUpdateAppCapabilitiesAction.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.additions().isEmpty());
    List<EntityReference> expectedRemovalsResult = json.removals;
    assertSame(expectedRemovalsResult, actualFromJsonResult.removals());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUpdateAppCapabilitiesAction#toString()}
   *   <li>{@link ImmutableUpdateAppCapabilitiesAction#additions()}
   *   <li>{@link ImmutableUpdateAppCapabilitiesAction#removals()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableUpdateAppCapabilitiesAction.additions()",
      "List ImmutableUpdateAppCapabilitiesAction.removals()", "String ImmutableUpdateAppCapabilitiesAction.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction buildResult = ImmutableUpdateAppCapabilitiesAction.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();
    List<EntityReference> actualAdditionsResult = buildResult.additions();
    List<EntityReference> actualRemovalsResult = buildResult.removals();

    // Assert
    assertEquals("UpdateAppCapabilitiesAction{additions=[], removals=[]}", actualToStringResult);
    assertTrue(actualAdditionsResult.isEmpty());
    assertSame(actualAdditionsResult, actualRemovalsResult);
  }

  /**
   * Test Json {@link Json#additions()}.
   * <p>
   * Method under test: {@link Json#additions()}
   */
  @Test
  @DisplayName("Test Json additions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.additions()"})
  void testJsonAdditions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).additions());
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
    assertTrue(actualJson.additions.isEmpty());
    assertTrue(actualJson.removals.isEmpty());
  }

  /**
   * Test Json {@link Json#removals()}.
   * <p>
   * Method under test: {@link Json#removals()}
   */
  @Test
  @DisplayName("Test Json removals()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.removals()"})
  void testJsonRemovals() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).removals());
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#withAdditions(EntityReference[])} with {@code EntityReference[]}.
   * <ul>
   *   <li>Then return additions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateAppCapabilitiesAction#withAdditions(EntityReference[])}
   */
  @Test
  @DisplayName("Test withAdditions(EntityReference[]) with 'EntityReference[]'; then return additions size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableUpdateAppCapabilitiesAction ImmutableUpdateAppCapabilitiesAction.withAdditions(EntityReference[])"})
  void testWithAdditionsWithEntityReference_thenReturnAdditionsSizeIsOne() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction buildResult = ImmutableUpdateAppCapabilitiesAction.builder().build();

    // Act
    ImmutableUpdateAppCapabilitiesAction actualWithAdditionsResult = buildResult
        .withAdditions(mock(EntityReference.class));

    // Assert
    assertEquals(1, actualWithAdditionsResult.additions().size());
    assertTrue(actualWithAdditionsResult.removals().isEmpty());
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#withRemovals(EntityReference[])} with {@code EntityReference[]}.
   * <ul>
   *   <li>Then return removals size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateAppCapabilitiesAction#withRemovals(EntityReference[])}
   */
  @Test
  @DisplayName("Test withRemovals(EntityReference[]) with 'EntityReference[]'; then return removals size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableUpdateAppCapabilitiesAction ImmutableUpdateAppCapabilitiesAction.withRemovals(EntityReference[])"})
  void testWithRemovalsWithEntityReference_thenReturnRemovalsSizeIsOne() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction buildResult = ImmutableUpdateAppCapabilitiesAction.builder().build();

    // Act
    ImmutableUpdateAppCapabilitiesAction actualWithRemovalsResult = buildResult
        .withRemovals(mock(EntityReference.class));

    // Assert
    assertEquals(1, actualWithRemovalsResult.removals().size());
    assertTrue(actualWithRemovalsResult.additions().isEmpty());
  }
}
