package org.finos.waltz.service.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.data.physical_specification_definition.PhysicalSpecDefinitionSampleFileDao;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionSampleFile;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionSampleFileCreateCommand;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhysicalSpecDefinitionSampleFileServiceDiffblueTest {
  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionSampleFileService#create(long, PhysicalSpecDefinitionSampleFileCreateCommand)}
   */
  @Test
  void testCreate() {
    // Arrange
    PhysicalSpecDefinitionSampleFileDao dao = mock(PhysicalSpecDefinitionSampleFileDao.class);
    when(dao.create(Mockito.<PhysicalSpecDefinitionSampleFile>any())).thenReturn(1L);
    PhysicalSpecDefinitionSampleFileService physicalSpecDefinitionSampleFileService = new PhysicalSpecDefinitionSampleFileService(
        dao);
    PhysicalSpecDefinitionSampleFileCreateCommand command = mock(PhysicalSpecDefinitionSampleFileCreateCommand.class);
    when(command.fileData()).thenReturn("File Data");
    when(command.name()).thenReturn("Name");

    // Act
    long actualCreateResult = physicalSpecDefinitionSampleFileService.create(1L, command);

    // Assert
    verify(dao).create(isA(PhysicalSpecDefinitionSampleFile.class));
    verify(command).fileData();
    verify(command).name();
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionSampleFileService#delete(long)}
   */
  @Test
  void testDelete() {
    // Arrange
    PhysicalSpecDefinitionSampleFileDao dao = mock(PhysicalSpecDefinitionSampleFileDao.class);
    when(dao.delete(anyLong())).thenReturn(1);

    // Act
    int actualDeleteResult = (new PhysicalSpecDefinitionSampleFileService(dao)).delete(1L);

    // Assert
    verify(dao).delete(eq(1L));
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionSampleFileService#deleteForSpecDefinition(long)}
   */
  @Test
  void testDeleteForSpecDefinition() {
    // Arrange
    PhysicalSpecDefinitionSampleFileDao dao = mock(PhysicalSpecDefinitionSampleFileDao.class);
    when(dao.deleteForSpecDefinition(anyLong())).thenReturn(1);

    // Act
    int actualDeleteForSpecDefinitionResult = (new PhysicalSpecDefinitionSampleFileService(dao))
        .deleteForSpecDefinition(1L);

    // Assert
    verify(dao).deleteForSpecDefinition(eq(1L));
    assertEquals(1, actualDeleteForSpecDefinitionResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionSampleFileService#findForSpecDefinition(long)}
   */
  @Test
  void testFindForSpecDefinition() {
    // Arrange
    PhysicalSpecDefinitionSampleFileDao dao = mock(PhysicalSpecDefinitionSampleFileDao.class);
    Optional<PhysicalSpecDefinitionSampleFile> ofResult = Optional.of(mock(PhysicalSpecDefinitionSampleFile.class));
    when(dao.findForSpecDefinition(anyLong())).thenReturn(ofResult);

    // Act
    Optional<PhysicalSpecDefinitionSampleFile> actualFindForSpecDefinitionResult = (new PhysicalSpecDefinitionSampleFileService(
        dao)).findForSpecDefinition(1L);

    // Assert
    verify(dao).findForSpecDefinition(eq(1L));
    assertTrue(actualFindForSpecDefinitionResult.isPresent());
    assertSame(ofResult, actualFindForSpecDefinitionResult);
  }
}
