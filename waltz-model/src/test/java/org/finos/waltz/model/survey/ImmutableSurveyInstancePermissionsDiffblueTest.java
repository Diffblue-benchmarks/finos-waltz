package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstancePermissionsDiffblueTest {
  /**
   * Method under test: {@link ImmutableSurveyInstancePermissions.Builder#build()}
   */
  @Test
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
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions.Builder#canEdit(boolean)}
   */
  @Test
  void testBuilderCanEdit() {
    // Arrange
    ImmutableSurveyInstancePermissions.Builder builderResult = ImmutableSurveyInstancePermissions.builder();

    // Act
    ImmutableSurveyInstancePermissions.Builder actualCanEditResult = builderResult.canEdit(true);

    // Assert
    assertTrue(builderResult.build().canEdit());
    assertSame(builderResult, actualCanEditResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions.Builder#from(SurveyInstancePermissions)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyInstancePermissions.Builder builderResult = ImmutableSurveyInstancePermissions.builder();
    SurveyInstancePermissions instance = mock(SurveyInstancePermissions.class);
    when(instance.canEdit()).thenReturn(true);
    when(instance.hasOwnerRole()).thenReturn(true);
    when(instance.isAdmin()).thenReturn(true);
    when(instance.isMetaEdit()).thenReturn(true);
    when(instance.isOwner()).thenReturn(true);
    when(instance.isParticipant()).thenReturn(true);

    // Act
    ImmutableSurveyInstancePermissions.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).canEdit();
    verify(instance).hasOwnerRole();
    verify(instance).isAdmin();
    verify(instance).isMetaEdit();
    verify(instance).isOwner();
    verify(instance).isParticipant();
    ImmutableSurveyInstancePermissions buildResult = builderResult.build();
    assertTrue(buildResult.canEdit());
    assertTrue(buildResult.hasOwnerRole());
    assertTrue(buildResult.isAdmin());
    assertTrue(buildResult.isMetaEdit());
    assertTrue(buildResult.isOwner());
    assertTrue(buildResult.isParticipant());
    assertTrue(buildResult.hasOwnership());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions.Builder#hasOwnerRole(boolean)}
   */
  @Test
  void testBuilderHasOwnerRole() {
    // Arrange
    ImmutableSurveyInstancePermissions.Builder builderResult = ImmutableSurveyInstancePermissions.builder();

    // Act
    ImmutableSurveyInstancePermissions.Builder actualHasOwnerRoleResult = builderResult.hasOwnerRole(true);

    // Assert
    ImmutableSurveyInstancePermissions buildResult = builderResult.build();
    assertTrue(buildResult.hasOwnerRole());
    assertTrue(buildResult.hasOwnership());
    assertSame(builderResult, actualHasOwnerRoleResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions.Builder#isAdmin(boolean)}
   */
  @Test
  void testBuilderIsAdmin() {
    // Arrange
    ImmutableSurveyInstancePermissions.Builder builderResult = ImmutableSurveyInstancePermissions.builder();

    // Act
    ImmutableSurveyInstancePermissions.Builder actualIsAdminResult = builderResult.isAdmin(true);

    // Assert
    assertTrue(builderResult.build().isAdmin());
    assertSame(builderResult, actualIsAdminResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions.Builder#isMetaEdit(boolean)}
   */
  @Test
  void testBuilderIsMetaEdit() {
    // Arrange
    ImmutableSurveyInstancePermissions.Builder builderResult = ImmutableSurveyInstancePermissions.builder();

    // Act
    ImmutableSurveyInstancePermissions.Builder actualIsMetaEditResult = builderResult.isMetaEdit(true);

    // Assert
    assertTrue(builderResult.build().isMetaEdit());
    assertSame(builderResult, actualIsMetaEditResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions.Builder#isOwner(boolean)}
   */
  @Test
  void testBuilderIsOwner() {
    // Arrange
    ImmutableSurveyInstancePermissions.Builder builderResult = ImmutableSurveyInstancePermissions.builder();

    // Act
    ImmutableSurveyInstancePermissions.Builder actualIsOwnerResult = builderResult.isOwner(true);

    // Assert
    ImmutableSurveyInstancePermissions buildResult = builderResult.build();
    assertTrue(buildResult.isOwner());
    assertTrue(buildResult.hasOwnership());
    assertSame(builderResult, actualIsOwnerResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions.Builder#isParticipant(boolean)}
   */
  @Test
  void testBuilderIsParticipant() {
    // Arrange
    ImmutableSurveyInstancePermissions.Builder builderResult = ImmutableSurveyInstancePermissions.builder();

    // Act
    ImmutableSurveyInstancePermissions.Builder actualIsParticipantResult = builderResult.isParticipant(true);

    // Assert
    assertTrue(builderResult.build().isParticipant());
    assertSame(builderResult, actualIsParticipantResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions#copyOf(SurveyInstancePermissions)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyInstancePermissions instance = mock(SurveyInstancePermissions.class);
    when(instance.canEdit()).thenReturn(true);
    when(instance.hasOwnerRole()).thenReturn(true);
    when(instance.isAdmin()).thenReturn(true);
    when(instance.isMetaEdit()).thenReturn(true);
    when(instance.isOwner()).thenReturn(true);
    when(instance.isParticipant()).thenReturn(true);

    // Act
    ImmutableSurveyInstancePermissions actualCopyOfResult = ImmutableSurveyInstancePermissions.copyOf(instance);

    // Assert
    verify(instance).canEdit();
    verify(instance).hasOwnerRole();
    verify(instance).isAdmin();
    verify(instance).isMetaEdit();
    verify(instance).isOwner();
    verify(instance).isParticipant();
    assertTrue(actualCopyOfResult.canEdit());
    assertTrue(actualCopyOfResult.hasOwnerRole());
    assertTrue(actualCopyOfResult.isAdmin());
    assertTrue(actualCopyOfResult.isMetaEdit());
    assertTrue(actualCopyOfResult.isOwner());
    assertTrue(actualCopyOfResult.isParticipant());
    assertTrue(actualCopyOfResult.hasOwnership());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions#copyOf(SurveyInstancePermissions)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SurveyInstancePermissions instance = mock(SurveyInstancePermissions.class);
    when(instance.canEdit()).thenReturn(false);
    when(instance.hasOwnerRole()).thenReturn(true);
    when(instance.isAdmin()).thenReturn(true);
    when(instance.isMetaEdit()).thenReturn(true);
    when(instance.isOwner()).thenReturn(true);
    when(instance.isParticipant()).thenReturn(true);

    // Act
    ImmutableSurveyInstancePermissions actualCopyOfResult = ImmutableSurveyInstancePermissions.copyOf(instance);

    // Assert
    verify(instance).canEdit();
    verify(instance).hasOwnerRole();
    verify(instance).isAdmin();
    verify(instance).isMetaEdit();
    verify(instance).isOwner();
    verify(instance).isParticipant();
    assertFalse(actualCopyOfResult.canEdit());
    assertTrue(actualCopyOfResult.hasOwnerRole());
    assertTrue(actualCopyOfResult.isAdmin());
    assertTrue(actualCopyOfResult.isMetaEdit());
    assertTrue(actualCopyOfResult.isOwner());
    assertTrue(actualCopyOfResult.isParticipant());
    assertTrue(actualCopyOfResult.hasOwnership());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions#fromJson(ImmutableSurveyInstancePermissions.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange and Act
    ImmutableSurveyInstancePermissions actualFromJsonResult = ImmutableSurveyInstancePermissions
        .fromJson(new ImmutableSurveyInstancePermissions.Json());

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
   * Method under test: {@link ImmutableSurveyInstancePermissions.Json#canEdit()}
   */
  @Test
  void testJsonCanEdit() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstancePermissions.Json()).canEdit());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions.Json#hasOwnerRole()}
   */
  @Test
  void testJsonHasOwnerRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstancePermissions.Json()).hasOwnerRole());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstancePermissions.Json#isAdmin()}
   */
  @Test
  void testJsonIsAdmin() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstancePermissions.Json()).isAdmin());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions.Json#isMetaEdit()}
   */
  @Test
  void testJsonIsMetaEdit() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstancePermissions.Json()).isMetaEdit());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstancePermissions.Json#isOwner()}
   */
  @Test
  void testJsonIsOwner() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstancePermissions.Json()).isOwner());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions.Json#isParticipant()}
   */
  @Test
  void testJsonIsParticipant() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstancePermissions.Json()).isParticipant());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyInstancePermissions.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyInstancePermissions.Json actualJson = new ImmutableSurveyInstancePermissions.Json();

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
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions.Json#setCanEdit(boolean)}
   */
  @Test
  void testJsonSetCanEdit() {
    // Arrange
    ImmutableSurveyInstancePermissions.Json json = new ImmutableSurveyInstancePermissions.Json();

    // Act
    json.setCanEdit(true);

    // Assert
    assertTrue(json.canEdit);
    assertTrue(json.canEditIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions.Json#setHasOwnerRole(boolean)}
   */
  @Test
  void testJsonSetHasOwnerRole() {
    // Arrange
    ImmutableSurveyInstancePermissions.Json json = new ImmutableSurveyInstancePermissions.Json();

    // Act
    json.setHasOwnerRole(true);

    // Assert
    assertTrue(json.hasOwnerRole);
    assertTrue(json.hasOwnerRoleIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions.Json#setIsAdmin(boolean)}
   */
  @Test
  void testJsonSetIsAdmin() {
    // Arrange
    ImmutableSurveyInstancePermissions.Json json = new ImmutableSurveyInstancePermissions.Json();

    // Act
    json.setIsAdmin(true);

    // Assert
    assertTrue(json.isAdmin);
    assertTrue(json.isAdminIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions.Json#setIsMetaEdit(boolean)}
   */
  @Test
  void testJsonSetIsMetaEdit() {
    // Arrange
    ImmutableSurveyInstancePermissions.Json json = new ImmutableSurveyInstancePermissions.Json();

    // Act
    json.setIsMetaEdit(true);

    // Assert
    assertTrue(json.isMetaEdit);
    assertTrue(json.isMetaEditIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions.Json#setIsOwner(boolean)}
   */
  @Test
  void testJsonSetIsOwner() {
    // Arrange
    ImmutableSurveyInstancePermissions.Json json = new ImmutableSurveyInstancePermissions.Json();

    // Act
    json.setIsOwner(true);

    // Assert
    assertTrue(json.isOwner);
    assertTrue(json.isOwnerIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstancePermissions.Json#setIsParticipant(boolean)}
   */
  @Test
  void testJsonSetIsParticipant() {
    // Arrange
    ImmutableSurveyInstancePermissions.Json json = new ImmutableSurveyInstancePermissions.Json();

    // Act
    json.setIsParticipant(true);

    // Assert
    assertTrue(json.isParticipant);
    assertTrue(json.isParticipantIsSet);
  }
}
