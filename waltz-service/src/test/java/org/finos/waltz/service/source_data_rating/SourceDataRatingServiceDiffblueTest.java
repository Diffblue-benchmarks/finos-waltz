package org.finos.waltz.service.source_data_rating;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.data.source_data_rating.SourceDataRatingDao;
import org.finos.waltz.model.source_data_rating.SourceDataRating;
import org.junit.jupiter.api.Test;

class SourceDataRatingServiceDiffblueTest {
  /**
   * Method under test: {@link SourceDataRatingService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    SourceDataRatingDao dao = mock(SourceDataRatingDao.class);
    ArrayList<SourceDataRating> sourceDataRatingList = new ArrayList<>();
    when(dao.findAll()).thenReturn(sourceDataRatingList);

    // Act
    Collection<SourceDataRating> actualFindAllResult = (new SourceDataRatingService(dao)).findAll();

    // Assert
    verify(dao).findAll();
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(sourceDataRatingList, actualFindAllResult);
  }
}
