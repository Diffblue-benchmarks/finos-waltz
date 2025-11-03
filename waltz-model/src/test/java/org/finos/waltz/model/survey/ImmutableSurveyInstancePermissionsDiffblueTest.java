package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.survey.ImmutableSurveyInstancePermissions.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstancePermissions.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstancePermissionsDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstancePermissions Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSurveyInstancePermissions actualBuildResult = ImmutableSurveyInstancePermissions.builder().build();

    // Assert
    assertFalse(actualBuildResult.canEdit());
    assertFalse(actualBuildResult.hasOwnerRole());
    assertFalse(actualBuildResult.isAdmin());
    assertFalse(actualBuildResult.isMetaEdit());
    assertFalse(actualBuildResult.isOwner());
    assertFalse(actualBuildResult.isParticipant());
    assertFalse(actualBuildResult.hasOwnership());
  }

  /**
   * Test Builder {@link Builder#canEdit(boolean)}.
   * <p>
   * Method under test: {@link Builder#canEdit(boolean)}
   */
  @Test
  @DisplayName("Test Builder canEdit(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.canEdit(boolean)"})
  void testBuilderCanEdit() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstancePermissions.builder();

    // Act
    Builder actualCanEditResult = builderResult.canEdit(true);

    // Assert
    assertTrue(builderResult.build().canEdit());
    assertSame(builderResult, actualCanEditResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstancePermissions)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstancePermissions)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstancePermissions); when builder build; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstancePermissions)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstancePermissions.builder();
    ImmutableSurveyInstancePermissions instance = ImmutableSurveyInstancePermissions.builder().build();

    // Act and Assert
    assertSame(builderResult, builderResult.from(instance));
  }

  /**
   * Test Builder {@link Builder#hasOwnerRole(boolean)}.
   * <p>
   * Method under test: {@link Builder#hasOwnerRole(boolean)}
   */
  @Test
  @DisplayName("Test Builder hasOwnerRole(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.hasOwnerRole(boolean)"})
  void testBuilderHasOwnerRole() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstancePermissions.builder();

    // Act
    Builder actualHasOwnerRoleResult = builderResult.hasOwnerRole(true);

    // Assert
    ImmutableSurveyInstancePermissions buildResult = builderResult.build();
    assertTrue(buildResult.hasOwnerRole());
    assertTrue(buildResult.hasOwnership());
    assertSame(builderResult, actualHasOwnerRoleResult);
  }

  /**
   * Test Builder {@link Builder#isAdmin(boolean)}.
   * <p>
   * Method under test: {@link Builder#isAdmin(boolean)}
   */
  @Test
  @DisplayName("Test Builder isAdmin(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isAdmin(boolean)"})
  void testBuilderIsAdmin() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstancePermissions.builder();

    // Act
    Builder actualIsAdminResult = builderResult.isAdmin(true);

    // Assert
    assertTrue(builderResult.build().isAdmin());
    assertSame(builderResult, actualIsAdminResult);
  }

  /**
   * Test Builder {@link Builder#isMetaEdit(boolean)}.
   * <p>
   * Method under test: {@link Builder#isMetaEdit(boolean)}
   */
  @Test
  @DisplayName("Test Builder isMetaEdit(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isMetaEdit(boolean)"})
  void testBuilderIsMetaEdit() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstancePermissions.builder();

    // Act
    Builder actualIsMetaEditResult = builderResult.isMetaEdit(true);

    // Assert
    assertTrue(builderResult.build().isMetaEdit());
    assertSame(builderResult, actualIsMetaEditResult);
  }

  /**
   * Test Builder {@link Builder#isOwner(boolean)}.
   * <p>
   * Method under test: {@link Builder#isOwner(boolean)}
   */
  @Test
  @DisplayName("Test Builder isOwner(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isOwner(boolean)"})
  void testBuilderIsOwner() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstancePermissions.builder();

    // Act
    Builder actualIsOwnerResult = builderResult.isOwner(true);

    // Assert
    ImmutableSurveyInstancePermissions buildResult = builderResult.build();
    assertTrue(buildResult.isOwner());
    assertTrue(buildResult.hasOwnership());
    assertSame(builderResult, actualIsOwnerResult);
  }

  /**
   * Test Builder {@link Builder#isParticipant(boolean)}.
   * <p>
   * Method under test: {@link Builder#isParticipant(boolean)}
   */
  @Test
  @DisplayName("Test Builder isParticipant(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isParticipant(boolean)"})
  void testBuilderIsParticipant() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstancePermissions.builder();

    // Act
    Builder actualIsParticipantResult = builderResult.isParticipant(true);

    // Assert
    assertTrue(builderResult.build().isParticipant());
    assertSame(builderResult, actualIsParticipantResult);
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#copyOf(SurveyInstancePermissions)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return not canEdit.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstancePermissions#copyOf(SurveyInstancePermissions)}
   */
  @Test
  @DisplayName("Test copyOf(SurveyInstancePermissions); when builder build; then return not canEdit")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableSurveyInstancePermissions ImmutableSurveyInstancePermissions.copyOf(SurveyInstancePermissions)"})
  void testCopyOf_whenBuilderBuild_thenReturnNotCanEdit() {
    // Arrange
    ImmutableSurveyInstancePermissions instance = ImmutableSurveyInstancePermissions.builder().build();

    // Act
    ImmutableSurveyInstancePermissions actualCopyOfResult = ImmutableSurveyInstancePermissions.copyOf(instance);

    // Assert
    assertFalse(actualCopyOfResult.canEdit());
    assertFalse(actualCopyOfResult.hasOwnerRole());
    assertFalse(actualCopyOfResult.isAdmin());
    assertFalse(actualCopyOfResult.isMetaEdit());
    assertFalse(actualCopyOfResult.isOwner());
    assertFalse(actualCopyOfResult.isParticipant());
    assertFalse(actualCopyOfResult.hasOwnership());
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#equals(Object)}, and {@link ImmutableSurveyInstancePermissions#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyInstancePermissions#equals(Object)}
   *   <li>{@link ImmutableSurveyInstancePermissions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstancePermissions.equals(Object)",
      "int ImmutableSurveyInstancePermissions.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstancePermissions buildResult = ImmutableSurveyInstancePermissions.builder().build();
    ImmutableSurveyInstancePermissions buildResult2 = ImmutableSurveyInstancePermissions.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#equals(Object)}, and {@link ImmutableSurveyInstancePermissions#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyInstancePermissions#equals(Object)}
   *   <li>{@link ImmutableSurveyInstancePermissions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstancePermissions.equals(Object)",
      "int ImmutableSurveyInstancePermissions.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstancePermissions buildResult = ImmutableSurveyInstancePermissions.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstancePermissions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstancePermissions.equals(Object)",
      "int ImmutableSurveyInstancePermissions.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyInstancePermissions buildResult = ImmutableSurveyInstancePermissions.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstancePermissions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstancePermissions.equals(Object)",
      "int ImmutableSurveyInstancePermissions.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyInstancePermissions buildResult = ImmutableSurveyInstancePermissions.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableSurveyInstancePermissions");
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return not canEdit.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstancePermissions#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return not canEdit")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstancePermissions ImmutableSurveyInstancePermissions.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnNotCanEdit() {
    // Arrange and Act
    ImmutableSurveyInstancePermissions actualFromJsonResult = ImmutableSurveyInstancePermissions.fromJson(new Json());

    // Assert
    assertFalse(actualFromJsonResult.canEdit());
    assertFalse(actualFromJsonResult.hasOwnerRole());
    assertFalse(actualFromJsonResult.isAdmin());
    assertFalse(actualFromJsonResult.isMetaEdit());
    assertFalse(actualFromJsonResult.isOwner());
    assertFalse(actualFromJsonResult.isParticipant());
    assertFalse(actualFromJsonResult.hasOwnership());
  }

  /**
   * Test Json {@link Json#canEdit()}.
   * <p>
   * Method under test: {@link Json#canEdit()}
   */
  @Test
  @DisplayName("Test Json canEdit()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.canEdit()"})
  void testJsonCanEdit() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).canEdit());
  }

  /**
   * Test Json {@link Json#hasOwnerRole()}.
   * <p>
   * Method under test: {@link Json#hasOwnerRole()}
   */
  @Test
  @DisplayName("Test Json hasOwnerRole()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.hasOwnerRole()"})
  void testJsonHasOwnerRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).hasOwnerRole());
  }

  /**
   * Test Json {@link Json#isAdmin()}.
   * <p>
   * Method under test: {@link Json#isAdmin()}
   */
  @Test
  @DisplayName("Test Json isAdmin()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isAdmin()"})
  void testJsonIsAdmin() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isAdmin());
  }

  /**
   * Test Json {@link Json#isMetaEdit()}.
   * <p>
   * Method under test: {@link Json#isMetaEdit()}
   */
  @Test
  @DisplayName("Test Json isMetaEdit()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isMetaEdit()"})
  void testJsonIsMetaEdit() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isMetaEdit());
  }

  /**
   * Test Json {@link Json#isOwner()}.
   * <p>
   * Method under test: {@link Json#isOwner()}
   */
  @Test
  @DisplayName("Test Json isOwner()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isOwner()"})
  void testJsonIsOwner() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isOwner());
  }

  /**
   * Test Json {@link Json#isParticipant()}.
   * <p>
   * Method under test: {@link Json#isParticipant()}
   */
  @Test
  @DisplayName("Test Json isParticipant()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isParticipant()"})
  void testJsonIsParticipant() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isParticipant());
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
    assertFalse(actualJson.canEdit);
    assertFalse(actualJson.canEditIsSet);
    assertFalse(actualJson.hasOwnerRole);
    assertFalse(actualJson.hasOwnerRoleIsSet);
    assertFalse(actualJson.isAdmin);
    assertFalse(actualJson.isAdminIsSet);
    assertFalse(actualJson.isMetaEdit);
    assertFalse(actualJson.isMetaEditIsSet);
    assertFalse(actualJson.isOwner);
    assertFalse(actualJson.isOwnerIsSet);
    assertFalse(actualJson.isParticipant);
    assertFalse(actualJson.isParticipantIsSet);
  }

  /**
   * Test Json {@link Json#setCanEdit(boolean)}.
   * <p>
   * Method under test: {@link Json#setCanEdit(boolean)}
   */
  @Test
  @DisplayName("Test Json setCanEdit(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setCanEdit(boolean)"})
  void testJsonSetCanEdit() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCanEdit(true);

    // Assert
    assertTrue(json.canEdit);
    assertTrue(json.canEditIsSet);
  }

  /**
   * Test Json {@link Json#setHasOwnerRole(boolean)}.
   * <p>
   * Method under test: {@link Json#setHasOwnerRole(boolean)}
   */
  @Test
  @DisplayName("Test Json setHasOwnerRole(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setHasOwnerRole(boolean)"})
  void testJsonSetHasOwnerRole() {
    // Arrange
    Json json = new Json();

    // Act
    json.setHasOwnerRole(true);

    // Assert
    assertTrue(json.hasOwnerRole);
    assertTrue(json.hasOwnerRoleIsSet);
  }

  /**
   * Test Json {@link Json#setIsAdmin(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsAdmin(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsAdmin(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsAdmin(boolean)"})
  void testJsonSetIsAdmin() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsAdmin(true);

    // Assert
    assertTrue(json.isAdmin);
    assertTrue(json.isAdminIsSet);
  }

  /**
   * Test Json {@link Json#setIsMetaEdit(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsMetaEdit(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsMetaEdit(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsMetaEdit(boolean)"})
  void testJsonSetIsMetaEdit() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsMetaEdit(true);

    // Assert
    assertTrue(json.isMetaEdit);
    assertTrue(json.isMetaEditIsSet);
  }

  /**
   * Test Json {@link Json#setIsOwner(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsOwner(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsOwner(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsOwner(boolean)"})
  void testJsonSetIsOwner() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsOwner(true);

    // Assert
    assertTrue(json.isOwner);
    assertTrue(json.isOwnerIsSet);
  }

  /**
   * Test Json {@link Json#setIsParticipant(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsParticipant(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsParticipant(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsParticipant(boolean)"})
  void testJsonSetIsParticipant() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsParticipant(true);

    // Assert
    assertTrue(json.isParticipant);
    assertTrue(json.isParticipantIsSet);
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#toString()}.
   * <p>
   * Method under test: {@link ImmutableSurveyInstancePermissions#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ImmutableSurveyInstancePermissions.toString()"})
  void testToString() {
    // Arrange
    ImmutableSurveyInstancePermissions buildResult = ImmutableSurveyInstancePermissions.builder().build();

    // Act and Assert
    assertEquals("SurveyInstancePermissions{isAdmin=false, isOwner=false, hasOwnerRole=false, isParticipant=false,"
        + " isMetaEdit=false, canEdit=false}", buildResult.toString());
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#withCanEdit(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstancePermissions#withCanEdit(boolean)}
   */
  @Test
  @DisplayName("Test withCanEdit(boolean); when 'false'; then return builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstancePermissions ImmutableSurveyInstancePermissions.withCanEdit(boolean)"})
  void testWithCanEdit_whenFalse_thenReturnBuilderBuild() {
    // Arrange
    ImmutableSurveyInstancePermissions buildResult = ImmutableSurveyInstancePermissions.builder().build();

    // Act and Assert
    assertSame(buildResult, buildResult.withCanEdit(false));
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#withCanEdit(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return not hasOwnerRole.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstancePermissions#withCanEdit(boolean)}
   */
  @Test
  @DisplayName("Test withCanEdit(boolean); when 'true'; then return not hasOwnerRole")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstancePermissions ImmutableSurveyInstancePermissions.withCanEdit(boolean)"})
  void testWithCanEdit_whenTrue_thenReturnNotHasOwnerRole() {
    // Arrange
    ImmutableSurveyInstancePermissions buildResult = ImmutableSurveyInstancePermissions.builder().build();

    // Act
    ImmutableSurveyInstancePermissions actualWithCanEditResult = buildResult.withCanEdit(true);

    // Assert
    assertFalse(actualWithCanEditResult.hasOwnerRole());
    assertFalse(actualWithCanEditResult.isAdmin());
    assertFalse(actualWithCanEditResult.isMetaEdit());
    assertFalse(actualWithCanEditResult.isOwner());
    assertFalse(actualWithCanEditResult.isParticipant());
    assertFalse(actualWithCanEditResult.hasOwnership());
    assertTrue(actualWithCanEditResult.canEdit());
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#withHasOwnerRole(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstancePermissions#withHasOwnerRole(boolean)}
   */
  @Test
  @DisplayName("Test withHasOwnerRole(boolean); when 'false'; then return builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstancePermissions ImmutableSurveyInstancePermissions.withHasOwnerRole(boolean)"})
  void testWithHasOwnerRole_whenFalse_thenReturnBuilderBuild() {
    // Arrange
    ImmutableSurveyInstancePermissions buildResult = ImmutableSurveyInstancePermissions.builder().build();

    // Act and Assert
    assertSame(buildResult, buildResult.withHasOwnerRole(false));
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#withHasOwnerRole(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return not canEdit.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstancePermissions#withHasOwnerRole(boolean)}
   */
  @Test
  @DisplayName("Test withHasOwnerRole(boolean); when 'true'; then return not canEdit")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstancePermissions ImmutableSurveyInstancePermissions.withHasOwnerRole(boolean)"})
  void testWithHasOwnerRole_whenTrue_thenReturnNotCanEdit() {
    // Arrange
    ImmutableSurveyInstancePermissions buildResult = ImmutableSurveyInstancePermissions.builder().build();

    // Act
    ImmutableSurveyInstancePermissions actualWithHasOwnerRoleResult = buildResult.withHasOwnerRole(true);

    // Assert
    assertFalse(actualWithHasOwnerRoleResult.canEdit());
    assertFalse(actualWithHasOwnerRoleResult.isAdmin());
    assertFalse(actualWithHasOwnerRoleResult.isMetaEdit());
    assertFalse(actualWithHasOwnerRoleResult.isOwner());
    assertFalse(actualWithHasOwnerRoleResult.isParticipant());
    assertTrue(actualWithHasOwnerRoleResult.hasOwnerRole());
    assertTrue(actualWithHasOwnerRoleResult.hasOwnership());
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#withIsAdmin(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstancePermissions#withIsAdmin(boolean)}
   */
  @Test
  @DisplayName("Test withIsAdmin(boolean); when 'false'; then return builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstancePermissions ImmutableSurveyInstancePermissions.withIsAdmin(boolean)"})
  void testWithIsAdmin_whenFalse_thenReturnBuilderBuild() {
    // Arrange
    ImmutableSurveyInstancePermissions buildResult = ImmutableSurveyInstancePermissions.builder().build();

    // Act and Assert
    assertSame(buildResult, buildResult.withIsAdmin(false));
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#withIsAdmin(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return not canEdit.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstancePermissions#withIsAdmin(boolean)}
   */
  @Test
  @DisplayName("Test withIsAdmin(boolean); when 'true'; then return not canEdit")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstancePermissions ImmutableSurveyInstancePermissions.withIsAdmin(boolean)"})
  void testWithIsAdmin_whenTrue_thenReturnNotCanEdit() {
    // Arrange
    ImmutableSurveyInstancePermissions buildResult = ImmutableSurveyInstancePermissions.builder().build();

    // Act
    ImmutableSurveyInstancePermissions actualWithIsAdminResult = buildResult.withIsAdmin(true);

    // Assert
    assertFalse(actualWithIsAdminResult.canEdit());
    assertFalse(actualWithIsAdminResult.hasOwnerRole());
    assertFalse(actualWithIsAdminResult.isMetaEdit());
    assertFalse(actualWithIsAdminResult.isOwner());
    assertFalse(actualWithIsAdminResult.isParticipant());
    assertFalse(actualWithIsAdminResult.hasOwnership());
    assertTrue(actualWithIsAdminResult.isAdmin());
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#withIsMetaEdit(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstancePermissions#withIsMetaEdit(boolean)}
   */
  @Test
  @DisplayName("Test withIsMetaEdit(boolean); when 'false'; then return builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstancePermissions ImmutableSurveyInstancePermissions.withIsMetaEdit(boolean)"})
  void testWithIsMetaEdit_whenFalse_thenReturnBuilderBuild() {
    // Arrange
    ImmutableSurveyInstancePermissions buildResult = ImmutableSurveyInstancePermissions.builder().build();

    // Act and Assert
    assertSame(buildResult, buildResult.withIsMetaEdit(false));
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#withIsMetaEdit(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return not canEdit.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstancePermissions#withIsMetaEdit(boolean)}
   */
  @Test
  @DisplayName("Test withIsMetaEdit(boolean); when 'true'; then return not canEdit")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstancePermissions ImmutableSurveyInstancePermissions.withIsMetaEdit(boolean)"})
  void testWithIsMetaEdit_whenTrue_thenReturnNotCanEdit() {
    // Arrange
    ImmutableSurveyInstancePermissions buildResult = ImmutableSurveyInstancePermissions.builder().build();

    // Act
    ImmutableSurveyInstancePermissions actualWithIsMetaEditResult = buildResult.withIsMetaEdit(true);

    // Assert
    assertFalse(actualWithIsMetaEditResult.canEdit());
    assertFalse(actualWithIsMetaEditResult.hasOwnerRole());
    assertFalse(actualWithIsMetaEditResult.isAdmin());
    assertFalse(actualWithIsMetaEditResult.isOwner());
    assertFalse(actualWithIsMetaEditResult.isParticipant());
    assertFalse(actualWithIsMetaEditResult.hasOwnership());
    assertTrue(actualWithIsMetaEditResult.isMetaEdit());
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#withIsOwner(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstancePermissions#withIsOwner(boolean)}
   */
  @Test
  @DisplayName("Test withIsOwner(boolean); when 'false'; then return builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstancePermissions ImmutableSurveyInstancePermissions.withIsOwner(boolean)"})
  void testWithIsOwner_whenFalse_thenReturnBuilderBuild() {
    // Arrange
    ImmutableSurveyInstancePermissions buildResult = ImmutableSurveyInstancePermissions.builder().build();

    // Act and Assert
    assertSame(buildResult, buildResult.withIsOwner(false));
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#withIsOwner(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return not canEdit.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstancePermissions#withIsOwner(boolean)}
   */
  @Test
  @DisplayName("Test withIsOwner(boolean); when 'true'; then return not canEdit")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstancePermissions ImmutableSurveyInstancePermissions.withIsOwner(boolean)"})
  void testWithIsOwner_whenTrue_thenReturnNotCanEdit() {
    // Arrange
    ImmutableSurveyInstancePermissions buildResult = ImmutableSurveyInstancePermissions.builder().build();

    // Act
    ImmutableSurveyInstancePermissions actualWithIsOwnerResult = buildResult.withIsOwner(true);

    // Assert
    assertFalse(actualWithIsOwnerResult.canEdit());
    assertFalse(actualWithIsOwnerResult.hasOwnerRole());
    assertFalse(actualWithIsOwnerResult.isAdmin());
    assertFalse(actualWithIsOwnerResult.isMetaEdit());
    assertFalse(actualWithIsOwnerResult.isParticipant());
    assertTrue(actualWithIsOwnerResult.isOwner());
    assertTrue(actualWithIsOwnerResult.hasOwnership());
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#withIsParticipant(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstancePermissions#withIsParticipant(boolean)}
   */
  @Test
  @DisplayName("Test withIsParticipant(boolean); when 'false'; then return builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableSurveyInstancePermissions ImmutableSurveyInstancePermissions.withIsParticipant(boolean)"})
  void testWithIsParticipant_whenFalse_thenReturnBuilderBuild() {
    // Arrange
    ImmutableSurveyInstancePermissions buildResult = ImmutableSurveyInstancePermissions.builder().build();

    // Act and Assert
    assertSame(buildResult, buildResult.withIsParticipant(false));
  }

  /**
   * Test {@link ImmutableSurveyInstancePermissions#withIsParticipant(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return not canEdit.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstancePermissions#withIsParticipant(boolean)}
   */
  @Test
  @DisplayName("Test withIsParticipant(boolean); when 'true'; then return not canEdit")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableSurveyInstancePermissions ImmutableSurveyInstancePermissions.withIsParticipant(boolean)"})
  void testWithIsParticipant_whenTrue_thenReturnNotCanEdit() {
    // Arrange
    ImmutableSurveyInstancePermissions buildResult = ImmutableSurveyInstancePermissions.builder().build();

    // Act
    ImmutableSurveyInstancePermissions actualWithIsParticipantResult = buildResult.withIsParticipant(true);

    // Assert
    assertFalse(actualWithIsParticipantResult.canEdit());
    assertFalse(actualWithIsParticipantResult.hasOwnerRole());
    assertFalse(actualWithIsParticipantResult.isAdmin());
    assertFalse(actualWithIsParticipantResult.isMetaEdit());
    assertFalse(actualWithIsParticipantResult.isOwner());
    assertFalse(actualWithIsParticipantResult.hasOwnership());
    assertTrue(actualWithIsParticipantResult.isParticipant());
  }
}
