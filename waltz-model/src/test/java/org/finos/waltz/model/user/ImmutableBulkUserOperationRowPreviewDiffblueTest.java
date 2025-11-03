package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.user.BulkUserOperationRowPreview.ResolutionStatus;
import org.finos.waltz.model.user.ImmutableBulkUserOperationRowPreview.Builder;
import org.finos.waltz.model.user.ImmutableBulkUserOperationRowPreview.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkUserOperationRowPreviewDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#givenComment(String)}
   *   <li>{@link Builder#givenRole(String)}
   *   <li>{@link Builder#givenUser(String)}
   *   <li>{@link Builder#resolvedComment(String)}
   *   <li>{@link Builder#resolvedRole(String)}
   *   <li>{@link Builder#resolvedUser(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview Builder.build()", "Builder Builder.givenComment(String)",
      "Builder Builder.givenRole(String)", "Builder Builder.givenUser(String)",
      "Builder Builder.resolvedComment(String)", "Builder Builder.resolvedRole(String)",
      "Builder Builder.resolvedUser(String)"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualBuildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Assert
    assertEquals("Given Comment", actualBuildResult.givenComment());
    assertEquals("Given Role", actualBuildResult.givenRole());
    assertEquals("Given User", actualBuildResult.givenUser());
    assertEquals("Resolved Comment", actualBuildResult.resolvedComment());
    assertEquals("Resolved Role", actualBuildResult.resolvedRole());
    assertEquals("Resolved User", actualBuildResult.resolvedUser());
    assertEquals(ResolutionStatus.OK, actualBuildResult.status());
  }

  /**
   * Test Builder {@link Builder#from(BulkUserOperationRowPreview)}.
   * <p>
   * Method under test: {@link Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUserOperationRowPreview)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUserOperationRowPreview)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    ImmutableBulkUserOperationRowPreview instance = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUserOperationRowPreview)}.
   * <p>
   * Method under test: {@link Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUserOperationRowPreview)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUserOperationRowPreview)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    ImmutableBulkUserOperationRowPreview instance = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment(null)
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUserOperationRowPreview)}.
   * <p>
   * Method under test: {@link Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUserOperationRowPreview)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUserOperationRowPreview)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    ImmutableBulkUserOperationRowPreview instance = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole(null)
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUserOperationRowPreview)}.
   * <p>
   * Method under test: {@link Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUserOperationRowPreview)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUserOperationRowPreview)"})
  void testBuilderFrom4() {
    // Arrange
    Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    ImmutableBulkUserOperationRowPreview instance = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser(null)
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUserOperationRowPreview)}.
   * <p>
   * Method under test: {@link Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUserOperationRowPreview)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUserOperationRowPreview)"})
  void testBuilderFrom5() {
    // Arrange
    Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    ImmutableBulkUserOperationRowPreview instance = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment(null)
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUserOperationRowPreview)}.
   * <p>
   * Method under test: {@link Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUserOperationRowPreview)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUserOperationRowPreview)"})
  void testBuilderFrom6() {
    // Arrange
    Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    ImmutableBulkUserOperationRowPreview instance = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole(null)
        .resolvedUser("Resolved User")
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUserOperationRowPreview)}.
   * <p>
   * Method under test: {@link Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUserOperationRowPreview)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUserOperationRowPreview)"})
  void testBuilderFrom7() {
    // Arrange
    Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    ImmutableBulkUserOperationRowPreview instance = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser(null)
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#copyOf(BulkUserOperationRowPreview)}.
   * <ul>
   *   <li>Then return {@code Given Comment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#copyOf(BulkUserOperationRowPreview)}
   */
  @Test
  @DisplayName("Test copyOf(BulkUserOperationRowPreview); then return 'Given Comment'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.copyOf(BulkUserOperationRowPreview)"})
  void testCopyOf_thenReturnGivenComment() {
    // Arrange
    ImmutableBulkUserOperationRowPreview instance = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualCopyOfResult = ImmutableBulkUserOperationRowPreview.copyOf(instance);

    // Assert
    assertEquals("Given Comment", actualCopyOfResult.givenComment());
    assertEquals("Given Role", actualCopyOfResult.givenRole());
    assertEquals("Given User", actualCopyOfResult.givenUser());
    assertEquals("Resolved Comment", actualCopyOfResult.resolvedComment());
    assertEquals("Resolved Role", actualCopyOfResult.resolvedRole());
    assertEquals("Resolved User", actualCopyOfResult.resolvedUser());
    assertEquals(ResolutionStatus.OK, actualCopyOfResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}, and {@link ImmutableBulkUserOperationRowPreview#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   *   <li>{@link ImmutableBulkUserOperationRowPreview#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
      "int ImmutableBulkUserOperationRowPreview.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();
    ImmutableBulkUserOperationRowPreview buildResult2 = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}, and {@link ImmutableBulkUserOperationRowPreview#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   *   <li>{@link ImmutableBulkUserOperationRowPreview#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
      "int ImmutableBulkUserOperationRowPreview.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
      "int ImmutableBulkUserOperationRowPreview.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("42")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();
    ImmutableBulkUserOperationRowPreview buildResult2 = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
      "int ImmutableBulkUserOperationRowPreview.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("42")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();
    ImmutableBulkUserOperationRowPreview buildResult2 = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
      "int ImmutableBulkUserOperationRowPreview.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("42")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();
    ImmutableBulkUserOperationRowPreview buildResult2 = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
      "int ImmutableBulkUserOperationRowPreview.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("42")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();
    ImmutableBulkUserOperationRowPreview buildResult2 = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
      "int ImmutableBulkUserOperationRowPreview.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("42")
        .resolvedUser("Resolved User")
        .build();
    ImmutableBulkUserOperationRowPreview buildResult2 = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
      "int ImmutableBulkUserOperationRowPreview.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("42")
        .build();
    ImmutableBulkUserOperationRowPreview buildResult2 = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
      "int ImmutableBulkUserOperationRowPreview.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
      "int ImmutableBulkUserOperationRowPreview.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableBulkUserOperationRowPreview");
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then return resolvedUser is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given empty string; then return resolvedUser is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.fromJson(Json)"})
  void testFromJson_givenEmptyString_thenReturnResolvedUserIsEmptyString() {
    // Arrange
    Json json = new Json();
    json.setGivenUser(null);
    json.setGivenRole(null);
    json.setGivenComment(null);
    json.setResolvedUser("");
    json.setResolvedRole(null);
    json.setResolvedComment("Json");

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("", actualFromJsonResult.resolvedUser());
    assertEquals("Json", actualFromJsonResult.resolvedComment());
    assertNull(actualFromJsonResult.givenComment());
    assertNull(actualFromJsonResult.givenRole());
    assertNull(actualFromJsonResult.givenUser());
    assertEquals(ResolutionStatus.ERROR, actualFromJsonResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code Json}.</li>
   *   <li>When {@link Json} (default constructor) GivenUser is {@code Json}.</li>
   *   <li>Then return givenUser is {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'Json'; when Json (default constructor) GivenUser is 'Json'; then return givenUser is 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonGivenUserIsJson_thenReturnGivenUserIsJson() {
    // Arrange
    Json json = new Json();
    json.setGivenUser("Json");
    json.setGivenRole(null);
    json.setGivenComment(null);
    json.setResolvedUser(null);
    json.setResolvedRole(null);
    json.setResolvedComment(null);

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.givenUser());
    assertNull(actualFromJsonResult.resolvedComment());
    assertNull(actualFromJsonResult.resolvedRole());
    assertNull(actualFromJsonResult.resolvedUser());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) GivenComment is {@code Json}.</li>
   *   <li>Then return givenComment is {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) GivenComment is 'Json'; then return givenComment is 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonGivenCommentIsJson_thenReturnGivenCommentIsJson() {
    // Arrange
    Json json = new Json();
    json.setGivenUser(null);
    json.setGivenRole(null);
    json.setGivenComment("Json");
    json.setResolvedUser(null);
    json.setResolvedRole(null);
    json.setResolvedComment(null);

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.givenComment());
    assertNull(actualFromJsonResult.resolvedComment());
    assertNull(actualFromJsonResult.resolvedRole());
    assertNull(actualFromJsonResult.resolvedUser());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) GivenRole is {@code Json}.</li>
   *   <li>Then return givenRole is {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) GivenRole is 'Json'; then return givenRole is 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonGivenRoleIsJson_thenReturnGivenRoleIsJson() {
    // Arrange
    Json json = new Json();
    json.setGivenUser(null);
    json.setGivenRole("Json");
    json.setGivenComment(null);
    json.setResolvedUser(null);
    json.setResolvedRole(null);
    json.setResolvedComment(null);

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.givenRole());
    assertNull(actualFromJsonResult.resolvedComment());
    assertNull(actualFromJsonResult.resolvedRole());
    assertNull(actualFromJsonResult.resolvedUser());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) ResolvedRole is {@code Json}.</li>
   *   <li>Then return resolvedRole is {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) ResolvedRole is 'Json'; then return resolvedRole is 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonResolvedRoleIsJson_thenReturnResolvedRoleIsJson() {
    // Arrange
    Json json = new Json();
    json.setGivenUser(null);
    json.setGivenRole(null);
    json.setGivenComment(null);
    json.setResolvedUser(null);
    json.setResolvedRole("Json");
    json.setResolvedComment(null);

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.resolvedRole());
    assertNull(actualFromJsonResult.givenComment());
    assertNull(actualFromJsonResult.givenRole());
    assertNull(actualFromJsonResult.givenUser());
    assertNull(actualFromJsonResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualFromJsonResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) ResolvedUser is {@code Json}.</li>
   *   <li>Then return resolvedRole is {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) ResolvedUser is 'Json'; then return resolvedRole is 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonResolvedUserIsJson_thenReturnResolvedRoleIsJson() {
    // Arrange
    Json json = new Json();
    json.setGivenUser(null);
    json.setGivenRole(null);
    json.setGivenComment(null);
    json.setResolvedUser("Json");
    json.setResolvedRole("Json");
    json.setResolvedComment(null);

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.resolvedRole());
    assertEquals("Json", actualFromJsonResult.resolvedUser());
    assertNull(actualFromJsonResult.givenComment());
    assertNull(actualFromJsonResult.givenRole());
    assertNull(actualFromJsonResult.givenUser());
    assertEquals(ResolutionStatus.ERROR, actualFromJsonResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) ResolvedUser is {@code Json}.</li>
   *   <li>Then return resolvedUser is {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) ResolvedUser is 'Json'; then return resolvedUser is 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonResolvedUserIsJson_thenReturnResolvedUserIsJson() {
    // Arrange
    Json json = new Json();
    json.setGivenUser(null);
    json.setGivenRole(null);
    json.setGivenComment(null);
    json.setResolvedUser("Json");
    json.setResolvedRole(null);
    json.setResolvedComment(null);

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.resolvedUser());
    assertNull(actualFromJsonResult.givenComment());
    assertNull(actualFromJsonResult.givenRole());
    assertNull(actualFromJsonResult.givenUser());
    assertEquals(ResolutionStatus.ERROR, actualFromJsonResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) ResolvedUser is {@code Json}.</li>
   *   <li>Then return status is {@code OK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) ResolvedUser is 'Json'; then return status is 'OK'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonResolvedUserIsJson_thenReturnStatusIsOk() {
    // Arrange
    Json json = new Json();
    json.setGivenUser(null);
    json.setGivenRole(null);
    json.setGivenComment(null);
    json.setResolvedUser("Json");
    json.setResolvedRole("Json");
    json.setResolvedComment("Json");

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.resolvedComment());
    assertEquals("Json", actualFromJsonResult.resolvedRole());
    assertEquals("Json", actualFromJsonResult.resolvedUser());
    assertEquals(ResolutionStatus.OK, actualFromJsonResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor) ResolvedComment is {@code Json}.</li>
   *   <li>Then return resolvedComment is {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor) ResolvedComment is 'Json'; then return resolvedComment is 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.fromJson(Json)"})
  void testFromJson_whenJsonResolvedCommentIsJson_thenReturnResolvedCommentIsJson() {
    // Arrange
    Json json = new Json();
    json.setGivenUser(null);
    json.setGivenRole(null);
    json.setGivenComment(null);
    json.setResolvedUser(null);
    json.setResolvedRole(null);
    json.setResolvedComment("Json");

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.resolvedComment());
    assertNull(actualFromJsonResult.givenComment());
    assertNull(actualFromJsonResult.givenRole());
    assertNull(actualFromJsonResult.givenUser());
    assertNull(actualFromJsonResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualFromJsonResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return givenComment is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return givenComment is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnGivenCommentIsNull() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult = ImmutableBulkUserOperationRowPreview
        .fromJson(new Json());

    // Assert
    assertNull(actualFromJsonResult.givenComment());
    assertNull(actualFromJsonResult.givenRole());
    assertNull(actualFromJsonResult.givenUser());
    assertNull(actualFromJsonResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualFromJsonResult.status());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkUserOperationRowPreview#toString()}
   *   <li>{@link ImmutableBulkUserOperationRowPreview#givenComment()}
   *   <li>{@link ImmutableBulkUserOperationRowPreview#givenRole()}
   *   <li>{@link ImmutableBulkUserOperationRowPreview#givenUser()}
   *   <li>{@link ImmutableBulkUserOperationRowPreview#resolvedComment()}
   *   <li>{@link ImmutableBulkUserOperationRowPreview#resolvedRole()}
   *   <li>{@link ImmutableBulkUserOperationRowPreview#resolvedUser()}
   *   <li>{@link ImmutableBulkUserOperationRowPreview#status()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ImmutableBulkUserOperationRowPreview.givenComment()",
      "String ImmutableBulkUserOperationRowPreview.givenRole()",
      "String ImmutableBulkUserOperationRowPreview.givenUser()",
      "String ImmutableBulkUserOperationRowPreview.resolvedComment()",
      "String ImmutableBulkUserOperationRowPreview.resolvedRole()",
      "String ImmutableBulkUserOperationRowPreview.resolvedUser()",
      "ResolutionStatus ImmutableBulkUserOperationRowPreview.status()",
      "String ImmutableBulkUserOperationRowPreview.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    String actualToStringResult = buildResult.toString();
    String actualGivenCommentResult = buildResult.givenComment();
    String actualGivenRoleResult = buildResult.givenRole();
    String actualGivenUserResult = buildResult.givenUser();
    String actualResolvedCommentResult = buildResult.resolvedComment();
    String actualResolvedRoleResult = buildResult.resolvedRole();
    String actualResolvedUserResult = buildResult.resolvedUser();

    // Assert
    assertEquals("BulkUserOperationRowPreview{givenUser=Given User, givenRole=Given Role, givenComment=Given Comment,"
        + " resolvedUser=Resolved User, resolvedRole=Resolved Role, resolvedComment=Resolved Comment," + " status=OK}",
        actualToStringResult);
    assertEquals("Given Comment", actualGivenCommentResult);
    assertEquals("Given Role", actualGivenRoleResult);
    assertEquals("Given User", actualGivenUserResult);
    assertEquals("Resolved Comment", actualResolvedCommentResult);
    assertEquals("Resolved Role", actualResolvedRoleResult);
    assertEquals("Resolved User", actualResolvedUserResult);
    assertEquals(ResolutionStatus.OK, buildResult.status());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setGivenComment(String)}
   *   <li>{@link Json#setGivenRole(String)}
   *   <li>{@link Json#setGivenUser(String)}
   *   <li>{@link Json#setResolvedComment(String)}
   *   <li>{@link Json#setResolvedRole(String)}
   *   <li>{@link Json#setResolvedUser(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setGivenComment(String)", "void Json.setGivenRole(String)",
      "void Json.setGivenUser(String)", "void Json.setResolvedComment(String)", "void Json.setResolvedRole(String)",
      "void Json.setResolvedUser(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setGivenComment("Given Comment");
    actualJson.setGivenRole("Given Role");
    actualJson.setGivenUser("Given User");
    actualJson.setResolvedComment("Resolved Comment");
    actualJson.setResolvedRole("Resolved Role");
    actualJson.setResolvedUser("Resolved User");

    // Assert
    assertEquals("Given Comment", actualJson.givenComment);
    assertEquals("Given Role", actualJson.givenRole);
    assertEquals("Given User", actualJson.givenUser);
    assertEquals("Resolved Comment", actualJson.resolvedComment);
    assertEquals("Resolved Role", actualJson.resolvedRole);
    assertEquals("Resolved User", actualJson.resolvedUser);
  }

  /**
   * Test Json {@link Json#givenComment()}.
   * <p>
   * Method under test: {@link Json#givenComment()}
   */
  @Test
  @DisplayName("Test Json givenComment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.givenComment()"})
  void testJsonGivenComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).givenComment());
  }

  /**
   * Test Json {@link Json#givenRole()}.
   * <p>
   * Method under test: {@link Json#givenRole()}
   */
  @Test
  @DisplayName("Test Json givenRole()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.givenRole()"})
  void testJsonGivenRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).givenRole());
  }

  /**
   * Test Json {@link Json#givenUser()}.
   * <p>
   * Method under test: {@link Json#givenUser()}
   */
  @Test
  @DisplayName("Test Json givenUser()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.givenUser()"})
  void testJsonGivenUser() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).givenUser());
  }

  /**
   * Test Json {@link Json#resolvedComment()}.
   * <p>
   * Method under test: {@link Json#resolvedComment()}
   */
  @Test
  @DisplayName("Test Json resolvedComment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.resolvedComment()"})
  void testJsonResolvedComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).resolvedComment());
  }

  /**
   * Test Json {@link Json#resolvedRole()}.
   * <p>
   * Method under test: {@link Json#resolvedRole()}
   */
  @Test
  @DisplayName("Test Json resolvedRole()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.resolvedRole()"})
  void testJsonResolvedRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).resolvedRole());
  }

  /**
   * Test Json {@link Json#resolvedUser()}.
   * <p>
   * Method under test: {@link Json#resolvedUser()}
   */
  @Test
  @DisplayName("Test Json resolvedUser()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.resolvedUser()"})
  void testJsonResolvedUser() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).resolvedUser());
  }

  /**
   * Test Json {@link Json#status()}.
   * <p>
   * Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResolutionStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}.
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}
   */
  @Test
  @DisplayName("Test withGivenComment(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenComment(String)"})
  void testWithGivenComment() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("42")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withGivenComment("42"));
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}.
   * <ul>
   *   <li>Then return resolvedComment is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}
   */
  @Test
  @DisplayName("Test withGivenComment(String); then return resolvedComment is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenComment(String)"})
  void testWithGivenComment_thenReturnResolvedCommentIsEmptyString() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithGivenCommentResult = buildResult.withGivenComment("42");

    // Assert
    assertEquals("", actualWithGivenCommentResult.resolvedComment());
    assertEquals("Resolved Role", actualWithGivenCommentResult.resolvedRole());
    assertEquals("Resolved User", actualWithGivenCommentResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenCommentResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}.
   * <ul>
   *   <li>Then return resolvedRole is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}
   */
  @Test
  @DisplayName("Test withGivenComment(String); then return resolvedRole is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenComment(String)"})
  void testWithGivenComment_thenReturnResolvedRoleIsEmptyString() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithGivenCommentResult = buildResult.withGivenComment("42");

    // Assert
    assertEquals("", actualWithGivenCommentResult.resolvedRole());
    assertEquals("Resolved Comment", actualWithGivenCommentResult.resolvedComment());
    assertEquals("Resolved User", actualWithGivenCommentResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenCommentResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}.
   * <ul>
   *   <li>Then return resolvedUser is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}
   */
  @Test
  @DisplayName("Test withGivenComment(String); then return resolvedUser is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenComment(String)"})
  void testWithGivenComment_thenReturnResolvedUserIsEmptyString() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithGivenCommentResult = buildResult.withGivenComment("42");

    // Assert
    assertEquals("", actualWithGivenCommentResult.resolvedUser());
    assertEquals("Resolved Comment", actualWithGivenCommentResult.resolvedComment());
    assertEquals("Resolved Role", actualWithGivenCommentResult.resolvedRole());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenCommentResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}.
   * <ul>
   *   <li>Then return status is {@code OK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}
   */
  @Test
  @DisplayName("Test withGivenComment(String); then return status is 'OK'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenComment(String)"})
  void testWithGivenComment_thenReturnStatusIsOk() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithGivenCommentResult = buildResult.withGivenComment("42");

    // Assert
    assertEquals("Resolved Comment", actualWithGivenCommentResult.resolvedComment());
    assertEquals("Resolved Role", actualWithGivenCommentResult.resolvedRole());
    assertEquals("Resolved User", actualWithGivenCommentResult.resolvedUser());
    assertEquals(ResolutionStatus.OK, actualWithGivenCommentResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}.
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}
   */
  @Test
  @DisplayName("Test withGivenRole(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenRole(String)"})
  void testWithGivenRole() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("42")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withGivenRole("42"));
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}.
   * <ul>
   *   <li>Then return resolvedComment is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}
   */
  @Test
  @DisplayName("Test withGivenRole(String); then return resolvedComment is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenRole(String)"})
  void testWithGivenRole_thenReturnResolvedCommentIsEmptyString() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithGivenRoleResult = buildResult.withGivenRole("42");

    // Assert
    assertEquals("", actualWithGivenRoleResult.resolvedComment());
    assertEquals("Resolved Role", actualWithGivenRoleResult.resolvedRole());
    assertEquals("Resolved User", actualWithGivenRoleResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenRoleResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}.
   * <ul>
   *   <li>Then return resolvedRole is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}
   */
  @Test
  @DisplayName("Test withGivenRole(String); then return resolvedRole is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenRole(String)"})
  void testWithGivenRole_thenReturnResolvedRoleIsEmptyString() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithGivenRoleResult = buildResult.withGivenRole("42");

    // Assert
    assertEquals("", actualWithGivenRoleResult.resolvedRole());
    assertEquals("Resolved Comment", actualWithGivenRoleResult.resolvedComment());
    assertEquals("Resolved User", actualWithGivenRoleResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenRoleResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}.
   * <ul>
   *   <li>Then return resolvedUser is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}
   */
  @Test
  @DisplayName("Test withGivenRole(String); then return resolvedUser is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenRole(String)"})
  void testWithGivenRole_thenReturnResolvedUserIsEmptyString() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithGivenRoleResult = buildResult.withGivenRole("42");

    // Assert
    assertEquals("", actualWithGivenRoleResult.resolvedUser());
    assertEquals("Resolved Comment", actualWithGivenRoleResult.resolvedComment());
    assertEquals("Resolved Role", actualWithGivenRoleResult.resolvedRole());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenRoleResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}.
   * <ul>
   *   <li>Then return status is {@code OK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}
   */
  @Test
  @DisplayName("Test withGivenRole(String); then return status is 'OK'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenRole(String)"})
  void testWithGivenRole_thenReturnStatusIsOk() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithGivenRoleResult = buildResult.withGivenRole("42");

    // Assert
    assertEquals("Resolved Comment", actualWithGivenRoleResult.resolvedComment());
    assertEquals("Resolved Role", actualWithGivenRoleResult.resolvedRole());
    assertEquals("Resolved User", actualWithGivenRoleResult.resolvedUser());
    assertEquals(ResolutionStatus.OK, actualWithGivenRoleResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}.
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}
   */
  @Test
  @DisplayName("Test withGivenUser(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenUser(String)"})
  void testWithGivenUser() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("42")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withGivenUser("42"));
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}.
   * <ul>
   *   <li>Then return resolvedComment is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}
   */
  @Test
  @DisplayName("Test withGivenUser(String); then return resolvedComment is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenUser(String)"})
  void testWithGivenUser_thenReturnResolvedCommentIsEmptyString() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithGivenUserResult = buildResult.withGivenUser("42");

    // Assert
    assertEquals("", actualWithGivenUserResult.resolvedComment());
    assertEquals("Resolved Role", actualWithGivenUserResult.resolvedRole());
    assertEquals("Resolved User", actualWithGivenUserResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenUserResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}.
   * <ul>
   *   <li>Then return resolvedRole is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}
   */
  @Test
  @DisplayName("Test withGivenUser(String); then return resolvedRole is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenUser(String)"})
  void testWithGivenUser_thenReturnResolvedRoleIsEmptyString() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithGivenUserResult = buildResult.withGivenUser("42");

    // Assert
    assertEquals("", actualWithGivenUserResult.resolvedRole());
    assertEquals("Resolved Comment", actualWithGivenUserResult.resolvedComment());
    assertEquals("Resolved User", actualWithGivenUserResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenUserResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}.
   * <ul>
   *   <li>Then return resolvedUser is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}
   */
  @Test
  @DisplayName("Test withGivenUser(String); then return resolvedUser is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenUser(String)"})
  void testWithGivenUser_thenReturnResolvedUserIsEmptyString() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithGivenUserResult = buildResult.withGivenUser("42");

    // Assert
    assertEquals("", actualWithGivenUserResult.resolvedUser());
    assertEquals("Resolved Comment", actualWithGivenUserResult.resolvedComment());
    assertEquals("Resolved Role", actualWithGivenUserResult.resolvedRole());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenUserResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}.
   * <ul>
   *   <li>Then return status is {@code OK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}
   */
  @Test
  @DisplayName("Test withGivenUser(String); then return status is 'OK'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenUser(String)"})
  void testWithGivenUser_thenReturnStatusIsOk() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithGivenUserResult = buildResult.withGivenUser("42");

    // Assert
    assertEquals("Resolved Comment", actualWithGivenUserResult.resolvedComment());
    assertEquals("Resolved Role", actualWithGivenUserResult.resolvedRole());
    assertEquals("Resolved User", actualWithGivenUserResult.resolvedUser());
    assertEquals(ResolutionStatus.OK, actualWithGivenUserResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}.
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}
   */
  @Test
  @DisplayName("Test withResolvedComment(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedComment(String)"})
  void testWithResolvedComment() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("42")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withResolvedComment("42"));
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}.
   * <ul>
   *   <li>Then return resolvedRole is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}
   */
  @Test
  @DisplayName("Test withResolvedComment(String); then return resolvedRole is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedComment(String)"})
  void testWithResolvedComment_thenReturnResolvedRoleIsEmptyString() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedCommentResult = buildResult.withResolvedComment("42");

    // Assert
    assertEquals("", actualWithResolvedCommentResult.resolvedRole());
    assertEquals("42", actualWithResolvedCommentResult.resolvedComment());
    assertEquals("Resolved User", actualWithResolvedCommentResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedCommentResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}.
   * <ul>
   *   <li>Then return resolvedUser is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}
   */
  @Test
  @DisplayName("Test withResolvedComment(String); then return resolvedUser is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedComment(String)"})
  void testWithResolvedComment_thenReturnResolvedUserIsEmptyString() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedCommentResult = buildResult.withResolvedComment("42");

    // Assert
    assertEquals("", actualWithResolvedCommentResult.resolvedUser());
    assertEquals("42", actualWithResolvedCommentResult.resolvedComment());
    assertEquals("Resolved Role", actualWithResolvedCommentResult.resolvedRole());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedCommentResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}.
   * <ul>
   *   <li>Then return status is {@code OK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}
   */
  @Test
  @DisplayName("Test withResolvedComment(String); then return status is 'OK'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedComment(String)"})
  void testWithResolvedComment_thenReturnStatusIsOk() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedCommentResult = buildResult.withResolvedComment("42");

    // Assert
    assertEquals("42", actualWithResolvedCommentResult.resolvedComment());
    assertEquals("Resolved Role", actualWithResolvedCommentResult.resolvedRole());
    assertEquals("Resolved User", actualWithResolvedCommentResult.resolvedUser());
    assertEquals(ResolutionStatus.OK, actualWithResolvedCommentResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return resolvedComment is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}
   */
  @Test
  @DisplayName("Test withResolvedComment(String); when empty string; then return resolvedComment is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedComment(String)"})
  void testWithResolvedComment_whenEmptyString_thenReturnResolvedCommentIsEmptyString() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedCommentResult = buildResult.withResolvedComment("");

    // Assert
    assertEquals("", actualWithResolvedCommentResult.resolvedComment());
    assertEquals("Resolved Role", actualWithResolvedCommentResult.resolvedRole());
    assertEquals("Resolved User", actualWithResolvedCommentResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedCommentResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}.
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}
   */
  @Test
  @DisplayName("Test withResolvedRole(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedRole(String)"})
  void testWithResolvedRole() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("42")
        .resolvedUser("Resolved User")
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withResolvedRole("42"));
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}.
   * <ul>
   *   <li>Then return resolvedComment is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}
   */
  @Test
  @DisplayName("Test withResolvedRole(String); then return resolvedComment is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedRole(String)"})
  void testWithResolvedRole_thenReturnResolvedCommentIsEmptyString() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedRoleResult = buildResult.withResolvedRole("42");

    // Assert
    assertEquals("", actualWithResolvedRoleResult.resolvedComment());
    assertEquals("42", actualWithResolvedRoleResult.resolvedRole());
    assertEquals("Resolved User", actualWithResolvedRoleResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedRoleResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}.
   * <ul>
   *   <li>Then return resolvedUser is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}
   */
  @Test
  @DisplayName("Test withResolvedRole(String); then return resolvedUser is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedRole(String)"})
  void testWithResolvedRole_thenReturnResolvedUserIsEmptyString() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedRoleResult = buildResult.withResolvedRole("42");

    // Assert
    assertEquals("", actualWithResolvedRoleResult.resolvedUser());
    assertEquals("42", actualWithResolvedRoleResult.resolvedRole());
    assertEquals("Resolved Comment", actualWithResolvedRoleResult.resolvedComment());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedRoleResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}.
   * <ul>
   *   <li>Then return status is {@code OK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}
   */
  @Test
  @DisplayName("Test withResolvedRole(String); then return status is 'OK'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedRole(String)"})
  void testWithResolvedRole_thenReturnStatusIsOk() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedRoleResult = buildResult.withResolvedRole("42");

    // Assert
    assertEquals("42", actualWithResolvedRoleResult.resolvedRole());
    assertEquals("Resolved Comment", actualWithResolvedRoleResult.resolvedComment());
    assertEquals("Resolved User", actualWithResolvedRoleResult.resolvedUser());
    assertEquals(ResolutionStatus.OK, actualWithResolvedRoleResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return resolvedRole is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}
   */
  @Test
  @DisplayName("Test withResolvedRole(String); when empty string; then return resolvedRole is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedRole(String)"})
  void testWithResolvedRole_whenEmptyString_thenReturnResolvedRoleIsEmptyString() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedRoleResult = buildResult.withResolvedRole("");

    // Assert
    assertEquals("", actualWithResolvedRoleResult.resolvedRole());
    assertEquals("Resolved Comment", actualWithResolvedRoleResult.resolvedComment());
    assertEquals("Resolved User", actualWithResolvedRoleResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedRoleResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}.
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}
   */
  @Test
  @DisplayName("Test withResolvedUser(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedUser(String)"})
  void testWithResolvedUser() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("42")
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withResolvedUser("42"));
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}.
   * <ul>
   *   <li>Then return resolvedComment is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}
   */
  @Test
  @DisplayName("Test withResolvedUser(String); then return resolvedComment is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedUser(String)"})
  void testWithResolvedUser_thenReturnResolvedCommentIsEmptyString() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedUserResult = buildResult.withResolvedUser("42");

    // Assert
    assertEquals("", actualWithResolvedUserResult.resolvedComment());
    assertEquals("42", actualWithResolvedUserResult.resolvedUser());
    assertEquals("Resolved Role", actualWithResolvedUserResult.resolvedRole());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedUserResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}.
   * <ul>
   *   <li>Then return resolvedRole is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}
   */
  @Test
  @DisplayName("Test withResolvedUser(String); then return resolvedRole is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedUser(String)"})
  void testWithResolvedUser_thenReturnResolvedRoleIsEmptyString() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedUserResult = buildResult.withResolvedUser("42");

    // Assert
    assertEquals("", actualWithResolvedUserResult.resolvedRole());
    assertEquals("42", actualWithResolvedUserResult.resolvedUser());
    assertEquals("Resolved Comment", actualWithResolvedUserResult.resolvedComment());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedUserResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}.
   * <ul>
   *   <li>Then return status is {@code OK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}
   */
  @Test
  @DisplayName("Test withResolvedUser(String); then return status is 'OK'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedUser(String)"})
  void testWithResolvedUser_thenReturnStatusIsOk() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedUserResult = buildResult.withResolvedUser("42");

    // Assert
    assertEquals("42", actualWithResolvedUserResult.resolvedUser());
    assertEquals("Resolved Comment", actualWithResolvedUserResult.resolvedComment());
    assertEquals("Resolved Role", actualWithResolvedUserResult.resolvedRole());
    assertEquals(ResolutionStatus.OK, actualWithResolvedUserResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return resolvedUser is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}
   */
  @Test
  @DisplayName("Test withResolvedUser(String); when empty string; then return resolvedUser is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedUser(String)"})
  void testWithResolvedUser_whenEmptyString_thenReturnResolvedUserIsEmptyString() {
    // Arrange
    ImmutableBulkUserOperationRowPreview buildResult = ImmutableBulkUserOperationRowPreview.builder()
        .givenComment("Given Comment")
        .givenRole("Given Role")
        .givenUser("Given User")
        .resolvedComment("Resolved Comment")
        .resolvedRole("Resolved Role")
        .resolvedUser("Resolved User")
        .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedUserResult = buildResult.withResolvedUser("");

    // Assert
    assertEquals("", actualWithResolvedUserResult.resolvedUser());
    assertEquals("Resolved Comment", actualWithResolvedUserResult.resolvedComment());
    assertEquals("Resolved Role", actualWithResolvedUserResult.resolvedRole());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedUserResult.status());
  }
}
