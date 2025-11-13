package org.finos.waltz.service.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.data.physical_specification_definition.PhysicalSpecDefinitionSampleFileDao;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionSampleFile;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionSampleFileCreateCommand;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionSampleFile;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionSampleFileCreateCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhysicalSpecDefinitionSampleFileServiceDiffblueTest {
  /**
   * Test {@link PhysicalSpecDefinitionSampleFileService#create(long,
   * PhysicalSpecDefinitionSampleFileCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalSpecDefinitionSampleFileDao} {@link
   *       PhysicalSpecDefinitionSampleFileDao#create(PhysicalSpecDefinitionSampleFile)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionSampleFileService#create(long,
   * PhysicalSpecDefinitionSampleFileCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test create(long, PhysicalSpecDefinitionSampleFileCreateCommand); given PhysicalSpecDefinitionSampleFileDao create(PhysicalSpecDefinitionSampleFile) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long PhysicalSpecDefinitionSampleFileService.create(long, PhysicalSpecDefinitionSampleFileCreateCommand)"
  })
  void testCreate_givenPhysicalSpecDefinitionSampleFileDaoCreateReturnOne_thenReturnOne() {
    // Arrange
    PhysicalSpecDefinitionSampleFileDao dao = mock(PhysicalSpecDefinitionSampleFileDao.class);
    when(dao.create(Mockito.<PhysicalSpecDefinitionSampleFile>any())).thenReturn(1L);
    PhysicalSpecDefinitionSampleFileService physicalSpecDefinitionSampleFileService =
        new PhysicalSpecDefinitionSampleFileService(dao);

    // Act
    long actualCreateResult =
        physicalSpecDefinitionSampleFileService.create(
            1L,
            ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder()
                .fileData("File Data")
                .name("Name")
                .build());

    // Assert
    verify(dao).create(isA(PhysicalSpecDefinitionSampleFile.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionSampleFileService#delete(long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionSampleFileService#delete(long)}
   */
  @Test
  @DisplayName("Test delete(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionSampleFileService.delete(long)"})
  void testDelete() {
    // Arrange
    PhysicalSpecDefinitionSampleFileDao dao = mock(PhysicalSpecDefinitionSampleFileDao.class);
    when(dao.delete(anyLong())).thenReturn(1);

    // Act
    int actualDeleteResult = new PhysicalSpecDefinitionSampleFileService(dao).delete(1L);

    // Assert
    verify(dao).delete(1L);
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionSampleFileService#deleteForSpecDefinition(long)}.
   *
   * <p>Method under test: {@link
   * PhysicalSpecDefinitionSampleFileService#deleteForSpecDefinition(long)}
   */
  @Test
  @DisplayName("Test deleteForSpecDefinition(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionSampleFileService.deleteForSpecDefinition(long)"})
  void testDeleteForSpecDefinition() {
    // Arrange
    PhysicalSpecDefinitionSampleFileDao dao = mock(PhysicalSpecDefinitionSampleFileDao.class);
    when(dao.deleteForSpecDefinition(anyLong())).thenReturn(1);

    // Act
    int actualDeleteForSpecDefinitionResult =
        new PhysicalSpecDefinitionSampleFileService(dao).deleteForSpecDefinition(1L);

    // Assert
    verify(dao).deleteForSpecDefinition(1L);
    assertEquals(1, actualDeleteForSpecDefinitionResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionSampleFileService#findForSpecDefinition(long)}.
   *
   * <p>Method under test: {@link
   * PhysicalSpecDefinitionSampleFileService#findForSpecDefinition(long)}
   */
  @Test
  @DisplayName("Test findForSpecDefinition(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional PhysicalSpecDefinitionSampleFileService.findForSpecDefinition(long)"
  })
  void testFindForSpecDefinition() {
    // Arrange
    PhysicalSpecDefinitionSampleFileDao dao = mock(PhysicalSpecDefinitionSampleFileDao.class);
    ImmutablePhysicalSpecDefinitionSampleFile immutablePhysicalSpecDefinitionSampleFile =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build();
    Optional<PhysicalSpecDefinitionSampleFile> ofResult =
        Optional.of(immutablePhysicalSpecDefinitionSampleFile);
    when(dao.findForSpecDefinition(anyLong())).thenReturn(ofResult);

    // Act
    Optional<PhysicalSpecDefinitionSampleFile> actualFindForSpecDefinitionResult =
        new PhysicalSpecDefinitionSampleFileService(dao).findForSpecDefinition(1L);

    // Assert
    verify(dao).findForSpecDefinition(1L);
    assertSame(ofResult, actualFindForSpecDefinitionResult);
  }
}
